package ua.goit.server.handlers.developers;

import com.sun.net.httpserver.HttpExchange;
import ua.goit.model.Developer;
import ua.goit.server.handlers.AbstractHandler;
import ua.goit.service.DeveloperService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class DevelopersViewHandler extends AbstractHandler {

    private static DeveloperService service = DeveloperService.getInstance();


    @Override
   protected String getTemplateName() {
        return "developer";
    }

    @Override
    protected void get(HttpExchange exchange) {
        Map<String, String> urlParams = getUrlParams(exchange);
        String id = urlParams.get("id");
        if (id==null){
            throw new RuntimeException("Need id for developer");
        }

        Optional<Developer> developerOptional = service.get(Long.parseLong(id));
        developerOptional.map(user -> {
            Map<String, String> params = new HashMap<>();
            params.put("name", user.getName());
            params.put("id", user.getId().toString());
            params.put("sex", user.getSex());
            params.put("salary", user.getSalary().toString());
            params.put("age", user.getAge().toString());
            return params;
        }).ifPresent(params -> {
            handleResponse(exchange, params);
        });


    }
}

