package ua.servlets.special;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Project;
import ua.model.Skills;
import ua.service.HandleBodyUtil;
import ua.service.SpecialService;


import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/special")
public class SpecialServlet extends HttpServlet {

    private static SpecialService specialService = SpecialService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("skills", new Skills());
        req.setAttribute("project", new Project());
        req.setAttribute("isNew", true);
        req.getRequestDispatcher("special.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
