package ua.servlets.skills;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Developer;
import ua.model.Skills;
import ua.service.HandleBodyUtil;
import ua.service.SkillService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/skills")
public class SkillsServlet extends HttpServlet {

    private static SkillService skillService = SkillService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Skills> all = skillService.getAll();
        Object[] skills = all.toArray();
        req.setAttribute("skills", skills);
        req.getRequestDispatcher("skills.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Skills skills= HandleBodyUtil.getModelFromStream(req.getInputStream(),Skills.class);
        try {
            skillService.create(skills);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/skills");
    }
}
