package ua.servlets.special;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Developer;
import ua.model.Project;
import ua.service.HandleBodyUtil;
import ua.service.SpecialService;

import java.io.IOException;
import java.util.List;

@WebServlet("/tasktwo")
public class TaskTwo extends HttpServlet {
    
    private static SpecialService specialService = SpecialService.getInstance();
    List<Developer> developers;
    Project project = new Project();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object[] users = developers.toArray();
        req.setAttribute("developers", users);
        req.setAttribute("project", project);
        req.getRequestDispatcher("/taskTwo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.project = HandleBodyUtil.getModelFromStream(req.getInputStream(), Project.class);
        this.developers = specialService.task2(project);

    }
}
