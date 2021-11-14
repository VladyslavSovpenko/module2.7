package ua.goit.dao;

import ua.goit.DbHelper;
import ua.goit.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerDao extends AbstractDao<Customer> {
    @Override
    String getTableName() {
        return "customers";
    }

    @Override
    Customer mapToEntity(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getLong("id"));
        customer.setCountry(resultSet.getString("country"));
        customer.setName(resultSet.getString("name"));
        return customer;
    }

    @Override
    public Optional<Customer> create(Customer entity) throws SQLException {
        String sql = "insert into customers (name, country) values (?,?);";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCountry());
        });
        System.out.println("Records was created");
        return Optional.empty();
    }

    @Override
    public void update(Customer entity) throws SQLException {
        String sql = "update customers set name = ?, country = ? where id = ?";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getCountry());
            ps.setLong(3, entity.getId());
        });
        System.out.println("Record was updated");
    }
}
