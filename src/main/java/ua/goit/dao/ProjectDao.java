package ua.goit.dao;

import ua.goit.DbHelper;
import ua.goit.model.Project;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProjectDao extends AbstractDao<Project> {

    @Override
    String getTableName() {
        return "projects";
    }

    @Override
    Project mapToEntity(ResultSet resultSet) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getLong("id"));
        project.setName(resultSet.getString("name"));
        project.setCost(resultSet.getLong("cost"));
        project.setDate(resultSet.getDate("date_added"));
        project.setLanguage(resultSet.getString("language"));
        return project;
    }

    @Override
    public Optional<Project> create(Project entity) throws SQLException { //name, language, cost, date_added
        String sql = "insert into projects (name, language, cost, date_added) values (?,?,?,?);";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLanguage());
            ps.setLong(3, entity.getCost());
            ps.setDate(4, entity.getDate());
        });
        System.out.println("Records was created");
        return Optional.empty();
    }

    @Override
    public void update(Project entity) throws SQLException {
        String sql = "update projects set name = ?, language = ?, cost = ?, date_added = ? where id = ?";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLanguage());
            ps.setLong(3, entity.getCost());
            ps.setDate(4, entity.getDate());
            ps.setLong(5, entity.getId());
        });
        System.out.println("Record was updated");
    }
}
