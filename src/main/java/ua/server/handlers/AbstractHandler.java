package ua.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.service.TemplateHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractHandler implements HttpHandler {

    protected TemplateHandler templateHandler = TemplateHandler.getInstance();
    public static final Logger LOGGER = LogManager.getLogger(AbstractHandler.class);

    protected abstract String getTemplateName();

    protected void get(HttpExchange exchange) {
    }

    protected void post(HttpExchange exchange) {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestMethod()) {
            case "GET":
                get(exchange);
                break;
            case "POST":
                post(exchange);
                break;
        }
    }

    protected Map<String, String> getUrlParams(HttpExchange exchange) {
        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();
        if (query == null) {
            return Collections.EMPTY_MAP;
        }
        return Arrays.stream(query.split("&"))
                .map(s -> s.split("="))
                .collect(Collectors.toMap(k -> k[0], o -> o[1]));
    }


    protected void handleResponse(HttpExchange exchange) {
        handleResponse(exchange, Collections.EMPTY_MAP);
    }

    protected void handleResponse(HttpExchange exchange, Map<String, String> params) {
        String body = templateHandler.handleTemplate(getTemplateName(), params);
        try (OutputStream outputStream = exchange.getResponseBody()) {
            exchange.sendResponseHeaders(200, body.length());
            outputStream.write(body.getBytes());
        } catch (IOException e) {
            LOGGER.error("Problem with sending response", e);
        }
    }


}
