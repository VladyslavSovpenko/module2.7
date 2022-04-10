package ua.dao;


import ua.config.PersistenceProvider;
import ua.model.Skills;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SkillDao extends AbstractDao<Skills> {

    public SkillDao() {
        super(Skills.class);
    }
}
