package ua.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.server.handlers.AbstractHandler;
import ua.service.DeveloperService;

import java.util.Collections;


public class DevelopersCreateHandler extends AbstractHandler {

    private static DeveloperService service = DeveloperService.getInstance();


    @Override
    protected String getTemplateName() {
        return "developer";
    }

    @Override
    protected void get(HttpExchange exchange) {
        handleResponse(exchange, Collections.EMPTY_MAP);

    }
}

