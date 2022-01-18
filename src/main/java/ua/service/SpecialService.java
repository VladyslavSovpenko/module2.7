package ua.service;

import org.apache.log4j.Logger;
import ua.dao.SpecialDao;
import ua.model.Developer;
import ua.model.Project;
import ua.model.Skills;

import java.sql.SQLException;
import java.util.List;

public class SpecialService {

    public static final Logger LOGGER = Logger.getLogger(SpecialService.class);
    private final SpecialDao specialDao = new SpecialDao();
    private static SpecialService instance;

    private SpecialService() {
    }

    public static SpecialService getInstance() {
        if (instance == null) {
            instance = new SpecialService();
        }
        return instance;
    }

    public Project task1(Project project) {
        Project project1 = new Project();
        project1.setName(project.getName());
        try {
            String salary = specialDao.getDevsSalaryOnSeparateProjectDao(project1.getName());
            project1.setCost(Long.parseLong(salary));
        } catch (SQLException e) {
            LOGGER.error("Task1 error", e);
        }

        return project1;
    }

    public List<Developer> task2(Project project) {
        List<Developer> list = null;
        try {
            list = specialDao.getDeveloperListOfProjectDao(project.getName());
        } catch (SQLException e) {
            LOGGER.error("Task2 error", e);
        }
        return list;
    }

    public List<Developer> task3(Skills skills) {
        List<Developer> list = null;
        try {
            list = specialDao.getDevsWithLangListDao(skills.getLanguage());
        } catch (SQLException e) {
            LOGGER.error("Task3 error", e);
        }
        return list;
    }

    public List<Developer> task4(Skills skills2) {
        List<Developer> list = null;
        try {
            list = specialDao.getDevsWithLevelListDao(skills2.getSkillRate());
        } catch (SQLException e) {
            LOGGER.error("Task4 error", e);
        }
        return list;
    }
}
