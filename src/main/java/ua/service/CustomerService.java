package ua.service;

import org.apache.log4j.Logger;
import ua.dao.CustomerDao;
import ua.model.Customers;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    public static final Logger LOGGER = Logger.getLogger(CustomerService.class);
    private final CustomerDao customerDao = new CustomerDao();

    private static CustomerService instance;

    private CustomerService() {
    }

    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }

    public Optional<Customers> get(long id) {
        Optional<Customers> customerOptional = null;
        try {
            customerOptional = customerDao.get(id);
            return customerOptional;
        } catch (SQLException throwables) {
            LOGGER.error("Problem with method get", throwables);
        }
        return customerOptional;
    }

    public void update(Customers customer) throws SQLException {
        customerDao.update(customer);

    }

    public List<Customers> getAll() {
        List<Customers> all = null;
        try {
            all = customerDao.getAll();
        } catch (SQLException throwables) {
            LOGGER.error("Problem with getAll method",throwables);
        }
        return all;
    }

    public void delete(Customers customer) {
        customerDao.delete(customer);
    }

    public void create(Customers customer) throws SQLException {
        customerDao.create(customer);
    }
}
