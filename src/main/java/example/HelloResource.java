package example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Jersey Jetty example.";
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User hello(User user) {
        return user;
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> helloList() {

        List<User> list = new ArrayList<>();

        User obj1 = new User();
        obj1.id = 1;
        obj1.name = "user1";
        list.add(obj1);

        User obj2 = new User();
        obj2.id = 2;
        obj2.name = "user2";
        list.add(obj2);

        return list;

    }

}
