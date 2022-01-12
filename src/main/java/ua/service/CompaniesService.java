package ua.service;

import org.apache.log4j.Logger;
import ua.dao.CompaniesDao;
import ua.model.Companies;
import ua.model.Developer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CompaniesService {

    public static final Logger LOGGER = Logger.getLogger(CompaniesService.class);
    private static CompaniesDao companiesDao = new CompaniesDao();

    private static CompaniesService instance;

    private CompaniesService( ) {
          }
    public static CompaniesService getInstance(){
        if (instance == null){
            instance = new CompaniesService();
        }
        return instance;
    }

    public Optional<Companies> get(long id){
        Optional<Companies> companiesOptional = null;
        try {
           companiesOptional = companiesDao.get(id);
            return companiesOptional;
        } catch (SQLException throwables) {
            LOGGER.error("Problem with method get", throwables);
        }
        return companiesOptional;
    }

    public void update(Companies companies) throws SQLException {
        companiesDao.update(companies);
    }

    public List<Companies> getAll() {
        List<Companies> all = null;
        try {
            all = companiesDao.getAll();
        } catch (SQLException throwables) {
            LOGGER.error("Problem with getAll method",throwables);
        }
        return all;
    }

    public void delete(Companies companies) {
        companiesDao.delete(companies);
    }

    public void create(Companies companies) throws SQLException {
        companiesDao.create(companies);
    }
}
