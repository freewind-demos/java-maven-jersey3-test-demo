package example;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        // scan packages
        final ResourceConfig config = new ResourceConfig(HelloResource.class);

        // Start Jetty Server
        JettyHttpContainerFactory.createServer(URI.create("http://localhost:8080/"), config);
    }


}