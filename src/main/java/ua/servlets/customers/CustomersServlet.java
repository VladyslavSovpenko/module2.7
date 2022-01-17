package ua.servlets.customers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Companies;
import ua.model.Customers;
import ua.service.CompaniesService;
import ua.service.CustomerService;
import ua.service.HandleBodyUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/customers")
public class CustomersServlet extends HttpServlet {
    private static CustomerService customerService = CustomerService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Customers customers = new Customers();
            customers.setId(Long.parseLong(deleteId));
            customerService.delete(customers);
        }

        List<Customers> all = customerService.getAll();
        Object[] customers = all.toArray();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("customers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customers customers = HandleBodyUtil.getModelFromStream(req.getInputStream(), Customers.class);
        try {
            customerService.create(customers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/customers");
    }
}
