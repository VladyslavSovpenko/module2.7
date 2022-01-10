package ua.service;

import org.apache.log4j.Logger;
import ua.dao.ProjectDao;
import ua.model.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProjectService {

    public static final Logger LOGGER = Logger.getLogger(DeveloperService.class);
    public final ProjectDao projectDao = new ProjectDao();

    private static ProjectService instance;

    private ProjectService() {
    }

    public static ProjectService getInstance() {
        if (instance==null){
            instance= new ProjectService();
        }
        return instance;
    }

    public Optional<Project> get(long id) {
        Optional<Project> projectOptional = null;
        try {
            projectOptional = projectDao.get(id);
        } catch (SQLException e) {
            LOGGER.error("Problem with method get", e);
        }
        return projectOptional;
    }

    public void update(Project project){
        try {
            projectDao.update(project);
        } catch (SQLException e) {
            LOGGER.error("Problem with method update", e);
        }
    }

    public List<Project> getAll() {
        List<Project> projects = null;
        try {
            projects = projectDao.getAll();
        } catch (SQLException e) {
            LOGGER.error("Problem with method getAll", e);
        }
        return projects;
    }

    public void delete(Project project){
        projectDao.delete(project);
    }

    public void create(Project project){
        try {
            projectDao.create(project);
        } catch (SQLException e) {
            LOGGER.error("Problem with method create", e);
        }
    }
}
