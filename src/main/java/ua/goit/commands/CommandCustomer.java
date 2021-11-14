package ua.goit.commands;

import ua.goit.dao.CustomerDao;
import ua.goit.model.Customer;
import ua.goit.model.Developer;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CommandCustomer implements Command {

    private final CustomerDao customerDao = new CustomerDao();

    @Override
    public void handle(String params) throws SQLException {
        String[] i = params.split(" ");
        String subParams = String.join("", params.replace(i[0] + " ", ""));
        switch (i[0]) {
            case ("create"): //create Customer  C
                create(subParams);
                break;
            case ("get"): //Read Customer       R
                get(subParams);
                break;
            case ("delete"): //Delete Customer  D
                delete(subParams);
                break;
            case ("getAll"): //Get all Customer
                getAll();
                break;
            case ("update"): //Update Customer U
                update(subParams);
                break;
        }
    }

    public void create(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Customer customer = new Customer();
        customer.setCountry(paramsArray[1]);
        customer.setName(paramsArray[0]);
        customerDao.create(customer);
    }

    public void get(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Optional<Customer> customer = customerDao.get(Long.parseLong(paramsArray[0]));
        if (customer.isPresent()) {
            System.out.println(customer.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    public void delete(String params) throws SQLException {
        String[] paramsArray = params.split(" ");
        Optional<Customer> customer = customerDao.get(Long.parseLong(paramsArray[0]));
        if (customer.isPresent()) {
            customerDao.delete(customer.get());
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }

    public void getAll() throws SQLException {
        List<Customer> all = customerDao.getAll();
        System.out.println("Returned " + all.size() + " users");
        System.out.println(all);
    }

    public void update(String params) throws SQLException {  //id, name, country
        String[] paramsArray = params.split(" ");
        Optional<Customer> customerOptional = customerDao.get(Long.parseLong(paramsArray[0]));
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(paramsArray[1]);
            customer.setCountry(paramsArray[2]);
            customerDao.update(customer);
        } else {
            System.out.println("User with id " + paramsArray[0] + " not found");
        }
    }
}

