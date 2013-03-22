package net.craftforge.prototype.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Christian Bick
 */
@Path("/content")
public class ContentResource {

    public static class Content {
        public String text;

        public Content(String text) {
            this.text = text;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Content get() {
        return new Content("This is content text");
    }
}
