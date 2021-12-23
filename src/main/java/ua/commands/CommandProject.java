package ua.commands;

import ua.dao.ProjectDao;
import ua.model.Project;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class CommandProject implements Command {

    private final ProjectDao projectDao = new ProjectDao();

    @Override
    public void handle(String params) throws SQLException {
        String[] i = params.split(" ");
        String subParams = String.join("", params.replace(i[0] + " ", ""));
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

    public void create(String params) throws SQLException { //name, language, cost, date_added
        String[] paramsArray = params.split(" ");
        Project project = new Project();
        project.setName(paramsArray[0]);
        project.setLanguage(paramsArray[1]);
        project.setCost(Long.valueOf(paramsArray[2]));

        Date date = new Date(System.currentTimeMillis());
        project.setDate(date);
        projectDao.create(project);
    }

    public void get(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Optional<Project> project = projectDao.get(Long.valueOf(paramsArray[0]));
        if (project.isPresent()) {
            System.out.println(project.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    public void delete(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Optional<Project> project = projectDao.get(Long.valueOf(paramsArray[0]));
        if (project.isPresent()) {
            projectDao.delete(project.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    public void getAll() throws SQLException {
        List<Project> projects = projectDao.getAll();
        System.out.println("Returned " + projects.size() + " users");
        System.out.println(projects);

    }

    public void update(String params) throws SQLException {//name, language, cost, date_added
        String[] paramsArray = params.split(" ");
        Optional<Project> projectOptional = projectDao.get(Long.valueOf(paramsArray[0]));
        if (projectOptional.isPresent()) {
            Project project = new Project();
            project.setName(paramsArray[1]);
            project.setLanguage(paramsArray[2]);
            project.setCost(Long.valueOf(paramsArray[3]));
            Date date = new Date(System.currentTimeMillis());
            project.setDate(date);
            projectDao.update(project);
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }
}
