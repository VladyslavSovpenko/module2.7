package ua.servlets.special;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Project;
import ua.service.HandleBodyUtil;
import ua.service.SpecialService;

import java.io.IOException;

@WebServlet("/taskone")
public class TaskOne extends HttpServlet {

    private static SpecialService specialService = SpecialService.getInstance();
    Project project = new Project();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("project", project);
        req.getRequestDispatcher("/taskOne.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.project = HandleBodyUtil.getModelFromStream(req.getInputStream(), Project.class);
        this.project.setCost(specialService.task1(project).getCost());
        req.setAttribute("project", project);
        req.getRequestDispatcher("/taskOne.jsp").forward(req, resp);
    }
}
