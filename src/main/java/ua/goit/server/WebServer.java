package ua.goit.server;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.goit.server.handlers.developers.DevelopersCreateHandler;
import ua.goit.server.handlers.developers.DevelopersHandler;
import ua.goit.server.handlers.developers.DevelopersViewHandler;
import ua.goit.server.handlers.GeneralGetHandler;
import ua.goit.server.handlers.IndexHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.Executors;


public class WebServer {

    private final Map<String, HttpHandler> handlers = Map.of(
            "/", new IndexHandler(),
            "/developers", new DevelopersHandler(),
            "/developers-view", new DevelopersViewHandler(),
            "/developers-create", new DevelopersCreateHandler(),
            "/skills", new GeneralGetHandler("skills"),
            "/projects", new GeneralGetHandler("projects")
    );

    public static final Logger LOGGER = LogManager.getLogger(WebServer.class);

    public void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 80), 0);
            server.setExecutor(Executors.newFixedThreadPool(10));
            handlers.forEach(server::createContext);
            server.start();
        } catch (IOException e) {
            LOGGER.error("problem with starting web server", e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Start server");
        WebServer server = new WebServer();
        server.start();

    }
}
