package ua.service;

import org.apache.log4j.Logger;
import ua.dao.SkillDao;
import ua.model.Skills;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SkillService {

    public static final Logger LOGGER = Logger.getLogger(SkillService.class);
    private final SkillDao skillDao = new SkillDao();

    private static SkillService instance;

    private SkillService() {
    }

    public static SkillService getInstance() {
        if (instance == null) {
            instance = new SkillService();
        }
        return instance;
    }

    public Optional<Skills> get(long id) {
        Optional<Skills> skillOptional = null;
        try {
            skillOptional = skillDao.get(id);
            return skillOptional;
        } catch (SQLException throwables) {
            LOGGER.error("Problem with method get", throwables);
        }
        return skillOptional;
    }

    public void update(Skills skill) throws SQLException {
        skillDao.update(skill);

    }

    public List<Skills> getAll() {
        List<Skills> all = null;
        try {
            all = skillDao.getAll();
        } catch (SQLException throwables) {
            LOGGER.error("Problem with getAll method",throwables);
        }
        return all;
    }

    public void delete(Skills skill) {
        skillDao.delete(skill);
    }

    public void create(Skills skill) throws SQLException {
        skillDao.create(skill);
    }
}
