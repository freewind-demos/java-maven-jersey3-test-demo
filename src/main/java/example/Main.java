package example;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static String BASE_URI = "http://localhost:8080/";

    public static void main(String[] args) {
        startServer();
    }

    public static Server startServer() {
        final ResourceConfig config = new ResourceConfig(HelloResource.class);
        // Start Jetty Server
        return JettyHttpContainerFactory.createServer(URI.create(BASE_URI), config);
    }


}