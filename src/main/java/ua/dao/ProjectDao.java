package ua.dao;


import ua.config.PersistenceProvider;
import ua.model.Project;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProjectDao extends AbstractDao<Project> {


    public ProjectDao() {
        super(Project.class);


}
