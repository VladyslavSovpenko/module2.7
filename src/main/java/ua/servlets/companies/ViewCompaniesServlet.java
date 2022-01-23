package ua.servlets.companies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ua.model.Companies;
import ua.model.Developer;
import ua.service.CompaniesService;
import ua.service.HandleBodyUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/companies/*")
public class ViewCompaniesServlet extends HttpServlet {

    private static CompaniesService companiesService = CompaniesService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(11);

        if ("new".equalsIgnoreCase(id)) {
            req.setAttribute("companies", new Companies());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/jsp/company.jsp").forward(req, resp);
        }

        Optional<Companies> companiesOptional = companiesService.get(Long.parseLong(id));
        if (companiesOptional.isPresent()) {
            Companies companies = companiesOptional.get();
            req.setAttribute("companies", companies);
            req.getRequestDispatcher("/jsp/company.jsp").forward(req, resp);
        }
        resp.sendRedirect("/companies");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Companies companies = HandleBodyUtil.getModelFromStream(req.getInputStream(), Companies.class);

        if (companies != null) {
            try {
                companiesService.update(companies);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/companies");
    }
}
