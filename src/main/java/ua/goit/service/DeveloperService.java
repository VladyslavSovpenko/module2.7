package ua.goit.service;

import org.apache.log4j.Logger;
import ua.goit.commands.CommandDeveloper;
import ua.goit.dao.DeveloperDao;
import ua.goit.model.Developer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DeveloperService {

    public static final Logger LOGGER = Logger.getLogger(CommandDeveloper.class);
    private final DeveloperDao developerDao = new DeveloperDao();

    private static DeveloperService instance;

    private DeveloperService() {
    }

    public static DeveloperService getInstance() {
        if (instance == null) {
            instance = new DeveloperService();
        }
        return instance;
    }



    public Optional<Developer> get(long id) {
        Optional<Developer> developerOptional = null;
        try {
            developerOptional = developerDao.get(id);
            return developerOptional;
        } catch (SQLException throwables) {
            LOGGER.error("Problem with method get", throwables);
        }
        return developerOptional;
    }

    public void update(Developer dev) throws SQLException {
        developerDao.update(dev);

    }

    public List<Developer> getAll() {
        List<Developer> all = null;
        try {
            all = developerDao.getAll();
        } catch (SQLException throwables) {
            LOGGER.error("Problem with getAll method",throwables);
        }
        return all;
    }

    public void delete(Developer developer) {
        developerDao.delete(developer);
    }

    public void create(Developer dev) throws SQLException {
        developerDao.create(dev);
    }
}

