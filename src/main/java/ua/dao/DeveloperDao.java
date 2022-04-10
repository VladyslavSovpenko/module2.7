package ua.dao;


import ua.config.PersistenceProvider;
import ua.model.Developer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DeveloperDao extends AbstractDao<Developer> {


    public DeveloperDao() {
        super(Developer.class);
    }
}
