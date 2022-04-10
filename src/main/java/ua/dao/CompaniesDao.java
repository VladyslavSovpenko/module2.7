package ua.dao;


import ua.config.PersistenceProvider;
import ua.model.Companies;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CompaniesDao extends AbstractDao<Companies> {

    public CompaniesDao() {
        super(Companies.class);
    }


}

