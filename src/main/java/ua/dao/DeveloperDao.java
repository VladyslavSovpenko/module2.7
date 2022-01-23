package ua.dao;

import ua.DbHelper;
import ua.model.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DeveloperDao extends AbstractDao<Developer> {

    @Override
    String getTableName() {
        return "developers";
    }

    @Override
    public Developer mapToEntity(ResultSet resultSet) throws SQLException {
        Developer developer = new Developer();
        developer.setId(resultSet.getLong("id"));
        developer.setAge(resultSet.getLong("age"));
        developer.setName(resultSet.getString("name"));
        developer.setSalary(resultSet.getLong("salary"));
        developer.setSex(resultSet.getString("sex"));
               return developer;
    }

    @Override
    public Optional<Developer> create(Developer entity) throws SQLException {
        String sql = "insert into developers(name, age, sex, salary) values(?,?,?,?)";

        DbHelper.executeWithPreparedStatement(sql, ps -> {
                     ps.setString(1, entity.getName());
            ps.setLong(2, entity.getAge());
            ps.setString(3, entity.getSex());
            ps.setLong(4, entity.getSalary());
        });
        System.out.println("Records was created");
        return Optional.empty();
    }

    @Override
    public void update(Developer entity) throws SQLException {
        String sql = "update developers set salary = ?, name =?, age=?, sex=? where id=?";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getSalary());
            ps.setString(2, entity.getName());
            ps.setLong(3, entity.getAge());
            ps.setString(4, entity.getSex());
            ps.setLong(5, entity.getId());
        });
        System.out.println("Record was updated");
    }

    public Developer getByName(String name) throws SQLException {
        String query = String.format("select * from %s where name=?", getTableName());
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                query, ps -> {
                    ps.setString(1, name);
                });
        if (resultSet.next()) {
            System.out.println("Record was selected");
            return mapToEntity(resultSet);
        } else {
            return null;
        }
    }
}
