package ua.servlets;



import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Developer;
import ua.service.DeveloperService;
import ua.service.HandleBodyUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/developers")
public class DeveloperServlet extends HttpServlet {
    private static DeveloperService developerService = DeveloperService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Developer> all = developerService.getAll();
        Object[] users = all.toArray();
        request.setAttribute("developers", users);
        request.getRequestDispatcher("developers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Developer dev= HandleBodyUtil.getModelFromStream(req.getInputStream(),Developer.class);
        try {
            developerService.create(dev);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/developers");

    }
}
