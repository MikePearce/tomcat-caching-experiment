package net.craftforge.prototype.filters;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * @author Christian Bick
 */
public class SearchEngineFilter implements Filter {

    static final String FRAGMENT = "#!";
    static final String ESCAPED_FRAGMENT = "_escaped_fragment_";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Nothing to do
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String queryString = req.getQueryString();

        if (queryString != null && queryString.startsWith(ESCAPED_FRAGMENT)) {
            String url = req.getRequestURL().toString();
            String fragmentString = queryString.replaceFirst(ESCAPED_FRAGMENT, "");
            String prettyUrl = fragmentString.isEmpty() ? url : url + FRAGMENT + fragmentString;

            WebClient webClient = new WebClient(BrowserVersion.FIREFOX_17);
            HtmlPage htmlPage = webClient.getPage(prettyUrl);
            webClient.waitForBackgroundJavaScript(5000);

            String htmlPageAsXml = htmlPage.asXml();

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentLength(-1);
            Writer writer = resp.getWriter();
            writer.write(htmlPageAsXml);
            writer.flush();

            webClient.closeAllWindows();
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Nothing to do
    }
}
