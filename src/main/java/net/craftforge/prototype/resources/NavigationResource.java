package net.craftforge.prototype.resources;

import org.jboss.resteasy.annotations.cache.Cache;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Christian Bick
 */
@Path("/navigation")
public class NavigationResource {

    public static class MenuItem {

        public String name;
        public String url;

        public MenuItem() {
        }

        public MenuItem(String name, String url) {
            this.name = name;
            this.url = url;
        }
    }

    @GET
    @Cache(maxAge = 60)
    @Produces(MediaType.APPLICATION_JSON)
    public MenuItem[] get() {
        return new MenuItem[] {
                new MenuItem("Home", "http://localhost:8080/page/page.html"),
                new MenuItem("Google", "http://www.google.com"),
                new MenuItem("Amazon", "http://www.amazon.com")
        };
    }

}
