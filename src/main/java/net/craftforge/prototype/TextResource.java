package net.craftforge.prototype;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A JAX-RS class
 *
 * @author Christian Bick
 */
@Path("/rest")
@Produces(MediaType.TEXT_PLAIN)
public class TextResource {

    @Inject
    TestBean testBean;

    @GET
    public String get() {
        return testBean.testString;
    }


}
