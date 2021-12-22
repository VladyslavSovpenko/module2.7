package ua.goit.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.model.Developer;
import ua.goit.server.handlers.AbstractHandler;
import ua.goit.service.DeveloperService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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

