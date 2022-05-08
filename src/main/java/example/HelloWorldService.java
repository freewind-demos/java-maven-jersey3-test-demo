package example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg() {
        String msg = "sdf";
        String output = "{\"Jersey say\": \"" + msg + "\"}";
        return Response.status(200).entity(output).build();

    }

}
