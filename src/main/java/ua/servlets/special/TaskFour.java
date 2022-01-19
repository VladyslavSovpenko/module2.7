package ua.servlets.special;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Developer;
import ua.model.Skills;
import ua.service.HandleBodyUtil;
import ua.service.SpecialService;

import java.io.IOException;
import java.util.List;
@WebServlet("/taskfour")
public class TaskFour extends HttpServlet {

    private static SpecialService specialService = SpecialService.getInstance();
    Skills skills = new Skills();
    List<Developer> developers;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object[] users = developers.toArray();
        req.setAttribute("developers", users);
        req.setAttribute("skills", skills);
        req.getRequestDispatcher("/taskFour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.skills = HandleBodyUtil.getModelFromStream(req.getInputStream(), Skills.class);
        this.developers = specialService.task4(skills);

    }
}
