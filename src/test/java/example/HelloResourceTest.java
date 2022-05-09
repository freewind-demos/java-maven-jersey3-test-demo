package example;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.jetty.server.Server;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResourceTest {

    private static Server server;
    private static WebTarget target;

    @BeforeAll
    public static void beforeAllTests() {
        server = Main.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);
    }

    @AfterAll
    public static void afterAllTests() throws Exception {
        server.stop();
    }

    @Test
    public void testHello() {
        String response = target.path("hello").request().get(String.class);
        assertThat(response).isEqualTo("Jersey Jetty example.");
    }

    @Test
    public void testHelloUser() throws JSONException {
        String response = target.path("hello")
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.json("""
                {"id":111, "name":"aaa"}
                """), String.class);

        // convert json string to JSONObject
        JSONObject actual = new JSONObject(response);

        String expected = """
            {"name":"aaa","id":111}
            """;
        assertThat(actual).usingRecursiveComparison().isEqualTo(new JSONObject(expected));
    }

    @Test
    public void testHelloAll() throws JSONException {
        String response = target.path("hello/all")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);

        // convert json string to JSONArray
        JSONArray actual = new JSONArray(response);

        String expected = """
            [{"id":1,"name":"user1"},{"id":2,"name":"user2"}]
            """;
        assertThat(actual).usingRecursiveComparison().isEqualTo(new JSONArray(expected));
    }
}
