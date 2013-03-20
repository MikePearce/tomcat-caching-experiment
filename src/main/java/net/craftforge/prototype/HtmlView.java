package net.craftforge.prototype;

import org.jboss.resteasy.plugins.providers.html.View;

/**
 * @author Christian Bick
 */
public class HtmlView extends View {

    public static final String TEMPLATE_ROOT = "/WEB-INF/jsp/";

    public HtmlView(String path) {
        this(path, null, null);
    }

    public HtmlView(String path, Object model) {
        this(path, model, DEFAULT_MODEL_NAME);
    }

    public HtmlView(String path, Object model, String modelName) {
        super(TEMPLATE_ROOT + path, model, modelName);
    }
}
