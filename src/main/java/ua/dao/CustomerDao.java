package ua.dao;

import ua.DbHelper;
import ua.model.Customers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerDao extends AbstractDao<Customers> {
    @Override
    String getTableName() {
        return "customers";
    }

    @Override
    Customers mapToEntity(ResultSet resultSet) throws SQLException {
        Customers customer = new Customers();
        customer.setId(resultSet.getLong("id"));
        customer.setCountry(resultSet.getString("country"));
        customer.setName(resultSet.getString("name"));
        return customer;
    }

    @Override
    public Optional<Customers> create(Customers entity) throws SQLException {
        String sql = "insert into customers (name, country) values (?,?);";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCountry());
        });
        System.out.println("Records was created");
        return Optional.empty();
    }

    @Override
    public void update(Customers entity) throws SQLException {
        String sql = "update customers set name = ?, country = ? where id = ?";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCountry());
            ps.setLong(3, entity.getId());
        });
        System.out.println("Record was updated");
    }
}
