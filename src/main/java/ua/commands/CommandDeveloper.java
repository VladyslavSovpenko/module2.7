package ua.commands;

import org.apache.log4j.Logger;

import ua.model.Developer;
import ua.service.DeveloperService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class CommandDeveloper implements Command {

    public static final Logger LOGGER = Logger.getLogger(CommandDeveloper.class);

    private static final DeveloperService service = DeveloperService.getInstance();


    @Override
    public void handle(String params) throws SQLException {
        String[] i = params.split(" ");
        String subParams = String.join("", params.replace(i[0]+ " ",""));
        switch (i[0]) {
            case ("create"): //create Developer  C
                create(subParams);
                break;
            case ("get"): //Read Developer       R
                get(subParams);
                break;
            case ("delete"): //Delete Developer  D
                delete(subParams);
                break;
            case ("getAll"): //Get all Developers
                getAll();
                break;
            case ("update"): //Update Developers U
                update(subParams);
                break;
        }
    }

    public void create(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Developer dev = new Developer();
        dev.setId(Long.valueOf(paramsArray[0]));
        dev.setName(paramsArray[1]);
        dev.setAge(Long.valueOf(paramsArray[2]));
        dev.setSex(paramsArray[3]);
        dev.setSalary(Long.valueOf(paramsArray[4]));

        service.create(dev);
    }

    public void get(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Optional<Developer> developer = service.get(Long.parseLong(paramsArray[0]));
        if (developer.isPresent()) {
            System.out.println(developer.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    public void delete(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Optional<Developer> developer = service.get(Long.parseLong(paramsArray[0]));
        if (developer.isPresent()) {
            service.delete(developer.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    public void getAll() throws SQLException {
        List<Developer> all = service.getAll();
        System.out.println("Returned "+ all.size() + " users");
        System.out.println(all);
    }

    public void update(String params) throws SQLException {  //id, name, age, sex, salary
        String[] paramsArray = params.split(" ");
        Optional<Developer> developerOptional = service.get(Long.parseLong(paramsArray[0]));
        if (developerOptional.isPresent()) {
            Developer dev = developerOptional.get();
            dev.setName(paramsArray[1]);
            dev.setAge(Long.parseLong(paramsArray[2]));
            dev.setSex(paramsArray[3]);
            dev.setSalary(Long.parseLong(paramsArray[4]));
            service.update(dev);
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }
}
