package ua.servlets.skills;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Companies;
import ua.model.Developer;
import ua.model.Skills;
import ua.service.HandleBodyUtil;
import ua.service.SkillService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet("/skills/*")
public class ViewSkillServlet extends HttpServlet {

    private static SkillService skillService = SkillService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(8);
        if ("new".equalsIgnoreCase(id)){
            req.setAttribute("skills", new Skills());
            req.setAttribute("isNew", true);

            req.getRequestDispatcher("/skill.jsp").forward(req, resp);
        }
        Optional<Skills> skillsOptional = skillService.get(Long.parseLong(id));
        if (skillsOptional.isPresent()) {
            Skills skills = skillsOptional.get();
            req.setAttribute("skills", skills);
            req.getRequestDispatcher("/skill.jsp").forward(req, resp);
        }
        resp.sendRedirect("/skills");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Skills skills= HandleBodyUtil.getModelFromStream(req.getInputStream(),Skills.class);

        if (skills!=null){
            try {
                skillService.update(skills);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/skills");
    }
    }

