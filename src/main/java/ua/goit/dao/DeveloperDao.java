package ua.goit.dao;

import ua.goit.DbHelper;
import ua.goit.model.Developer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DeveloperDao extends AbstractDao<Developer> {

    @Override
    String getTableName() {
        return "developers";
    }

    @Override
    Developer mapToEntity(ResultSet resultSet) throws SQLException {
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
        String sql = "insert into developers(id, name, age, sex, salary) values(?,?,?,?,?)";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setLong(3, entity.getAge());
            ps.setString(4, entity.getSex());
            ps.setLong(5, entity.getSalary());
        });
        System.out.println("Records was created");
        return Optional.empty();
    }

    @Override
    public void update(Developer entity) throws SQLException {
        String sql = "update developers set salary = ?, name =? where id=?";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setLong(1, entity.getSalary());
            ps.setString(2, entity.getName());
            ps.setLong(3, entity.getId());
        });
        System.out.println("Record was updated");
    }
}
