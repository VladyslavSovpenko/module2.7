package ua.goit.server.handlers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.service.TemplateHandler;

import java.io.IOException;
import java.io.OutputStream;

public class IndexHandler extends AbstractHandler {

    private TemplateHandler templateHandler = TemplateHandler.getInstance();

    @Override
   protected String getTemplateName() {
        return "index";
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("get".equalsIgnoreCase(exchange.getRequestMethod())) {
            handleGet(exchange);
        }
    }


    private void handleGet(HttpExchange exchange) throws IOException {

        OutputStream outputStream = exchange.getResponseBody();
        String index = templateHandler.getTemplate("index");
        exchange.sendResponseHeaders(200, index.length());
        outputStream.write(index.getBytes());
        outputStream.close();


    }
}
