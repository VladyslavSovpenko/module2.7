package ua.dao;

import ua.DbHelper;
import ua.model.Companies;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CompaniesDao extends AbstractDao<Companies> {
    @Override
    String getTableName() {
        return "companies";
    }

    @Override
    Companies mapToEntity(ResultSet resultSet) throws SQLException {
        Companies comp = new Companies();
        comp.setId(resultSet.getLong("id"));
        comp.setName(resultSet.getString("name"));
        comp.setNumber(resultSet.getLong("number_of_projects"));
        return comp;
    }

    @Override
    public Optional<Companies> create(Companies entity) throws SQLException {
        String sql = "insert into companies (name, number_of_projects) values (?, ?);";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setLong(2, entity.getNumber());
        });
        System.out.println("Records 'companies' was created");
        return Optional.empty();
    }

    @Override
    public void update(Companies entity) throws SQLException {
        String sql = "update companies set name = ?, number_of_projects = ? where id =?;";

        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setLong(2, entity.getNumber());
            ps.setLong(3, entity.getId());
        });
        System.out.println("Record 'companies' was updated");
    }
}

