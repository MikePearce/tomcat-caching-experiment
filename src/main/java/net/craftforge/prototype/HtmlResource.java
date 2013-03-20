package net.craftforge.prototype;

import org.jboss.resteasy.plugins.providers.html.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * @author Christian Bick
 */
@Path("/html")
@Produces(MediaType.TEXT_HTML)
public class HtmlResource {

    public static class TestModel {
        String text;
        List<String> list;

        public String getText() {
            return text;
        }

        public List<String> getList() {
            return list;
        }
    }

    @GET
    public View get() {
        TestModel testModel = new TestModel();
        testModel.text = "Restful Hello World";
        testModel.list = Arrays.asList("value one", "value two", "value three");

        return new HtmlView("jspage.jsp", testModel);
    }
}
