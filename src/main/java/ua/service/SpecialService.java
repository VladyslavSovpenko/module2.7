package ua.service;

import org.apache.log4j.Logger;
import ua.dao.ProjectDao;
import ua.dao.SpecialDao;
import ua.model.Developer;
import ua.model.Project;
import ua.model.ProjectList;
import ua.model.Skills;

import java.sql.SQLException;
import java.util.List;

public class SpecialService {

    public static final Logger LOGGER = Logger.getLogger(SpecialService.class);
    private static SpecialService instance;
    private static ProjectDao projectDao = new ProjectDao();

    private SpecialService() {
    }

    public static SpecialService getInstance() {
        if (instance == null) {
            instance = new SpecialService();
        }
        return instance;
    }

    public Project task1(Project project) {
        List<Project> projectList = projectDao.getAll();
        Long cost = null;
        projectList.forEach(project1 ->{
            cost+=
        } );
        project.setCost();

        return project1;
    }

//    public List<Developer> task2(Project project) {
//        List<Developer> list = null;
//        try {
//            list = specialDao.getDeveloperListOfProjectDao(project.getName());
//        } catch (SQLException e) {
//            LOGGER.error("Task2 error", e);
//        }
//        return list;
//    }
//
//    public List<Developer> task3(Skills skills) {
//        List<Developer> list = null;
//        try {
//            list = specialDao.getDevsWithLangListDao(skills.getLanguage());
//        } catch (SQLException e) {
//            LOGGER.error("Task3 error", e);
//        }
//        return list;
//    }
//
//    public List<Developer> task4(Skills skills2) {
//        List<Developer> list = null;
//        try {
//            list = specialDao.getDevsWithLevelListDao(skills2.getSkillRate());
//        } catch (SQLException e) {
//            LOGGER.error("Task4 error", e);
//        }
//        return list;
//    }
//
//    public List<ProjectList> task5(){
//        List<ProjectList> projects =null;
//        try {
//           projects= specialDao.getProjectsListDao();
//        } catch (SQLException e) {
//            LOGGER.error("Task 5 error", e);
//        }
//        return projects;
//    }
}
