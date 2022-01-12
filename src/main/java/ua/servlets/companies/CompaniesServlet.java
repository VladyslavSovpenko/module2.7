package ua.servlets.companies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Companies;
import ua.service.CompaniesService;
import ua.service.HandleBodyUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/companies")
public class CompaniesServlet extends HttpServlet {

    private static CompaniesService companiesService = CompaniesService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Companies> all = companiesService.getAll();
        Object[] users = all.toArray();
        req.setAttribute("companies", users);
        req.getRequestDispatcher("companies.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Companies companies = HandleBodyUtil.getModelFromStream(req.getInputStream(), Companies.class);
        try {
            companiesService.create(companies);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/companies");
    }
}
