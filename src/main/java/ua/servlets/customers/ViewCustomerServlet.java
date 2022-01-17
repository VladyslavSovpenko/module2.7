package ua.servlets.customers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Companies;
import ua.model.Customers;
import ua.service.CustomerService;
import ua.service.HandleBodyUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/customers/*")
public class ViewCustomerServlet extends HttpServlet {

    private static CustomerService customerService = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(11);

        if ("new".equalsIgnoreCase(id)){
            req.setAttribute("customers", new Customers());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/customer.jsp").forward(req,resp);
        }

        Optional<Customers> customersOptional = customerService.get(Long.parseLong(id));
        if (customersOptional.isPresent()) {
            Customers customers = customersOptional.get();
            req.setAttribute("customers", customers);
            req.getRequestDispatcher("/customer.jsp").forward(req, resp);
        }
        resp.sendRedirect("/customers");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customers customers= HandleBodyUtil.getModelFromStream(req.getInputStream(),Customers.class);

        if (customers!=null){
            try {
                customerService.update(customers);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/customers");
    }
}
