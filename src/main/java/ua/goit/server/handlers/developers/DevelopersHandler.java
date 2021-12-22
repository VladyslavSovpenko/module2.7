package ua.goit.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.model.Developer;
import ua.goit.server.handlers.AbstractHandler;
import ua.goit.service.DeveloperService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DevelopersHandler extends AbstractHandler {

    private static DeveloperService service = DeveloperService.getInstance();


    @Override
    protected String getTemplateName() {
        return "developers";
    }

    @Override
    protected void get(HttpExchange exchange) {

        List<Developer> all = service.getAll();
        String rowsTemplates = all.stream()
                .map(user -> {
                    Map<String, String> params = new HashMap<>();
                    params.put("name", user.getName());
                    params.put("id", user.getId().toString());
                    params.put("sex", user.getSex());
                    params.put("salary", user.getSalary().toString());
                    params.put("age", user.getAge().toString());
                    return templateHandler.handleTemplate("table-row", params);
                })
                .collect(Collectors.joining());
        handleResponse(exchange, Map.of("tableRows", rowsTemplates));
    }
}

