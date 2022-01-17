package ua.service;

import org.apache.log4j.Logger;
import ua.dao.SpecialDao;

import java.sql.SQLException;
import java.util.List;

public class SpecialService {

    public static final Logger LOGGER = Logger.getLogger(SpecialService.class);
    private final SpecialDao specialDao = new SpecialDao();
    private static SpecialService instance;

    private SpecialService() {
    }

    public static SpecialService getInstance() {
        if (instance==null){
            instance = new SpecialService();
        }
        return instance;
    }

    public String task1(String params) {
        String salary = null;
        try {
            salary = specialDao.getDevsSalaryOnSeparateProjectDao(params);
        } catch (SQLException e) {
            LOGGER.error("Task1 error", e);
        }
        return salary;
    }

    public List<String> task2(String params){
        List<String> list = null;
        try {
           list = specialDao.getDeveloperListOfProjectDao(params);
        } catch (SQLException e) {
            LOGGER.error("Task2 error", e);
        }
        return list;
    }

}
