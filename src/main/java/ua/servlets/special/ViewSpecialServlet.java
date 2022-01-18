package ua.servlets.special;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ua.dao.AbstractDao;
import ua.dao.DeveloperDao;
import ua.model.Developer;
import ua.model.Project;
import ua.model.Skills;
import ua.service.HandleBodyUtil;
import ua.service.SpecialService;

import java.io.IOException;
import java.util.List;

@WebServlet("/special/*")
public class ViewSpecialServlet extends HttpServlet {

    private static SpecialService specialService = SpecialService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(9);
        switch (id) {
            case ("1"):
                Project project = HandleBodyUtil.getModelFromStream(req.getInputStream(), Project.class);
                project.setCost(specialService.task1(project).getCost());
                req.setAttribute("project", project);
                req.getRequestDispatcher("taskOne.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(9);
        switch (id) {
            case ("1"):
                Project project = HandleBodyUtil.getModelFromStream(req.getInputStream(), Project.class);
                project.setCost(specialService.task1(project).getCost());
                req.setAttribute("project", project);
                req.getRequestDispatcher("/taskOne.jsp").forward(req, resp);
                break;
            case ("2"):
                Project project2 = HandleBodyUtil.getModelFromStream(req.getInputStream(), Project.class);
                List<Developer> developers = specialService.task2(project2);
                req.setAttribute("developers", developers);
                req.setAttribute("project", project2);
                req.getRequestDispatcher("/taskTwo.jsp").forward(req, resp);
                break;
            case ("3"):
                Skills skills= HandleBodyUtil.getModelFromStream(req.getInputStream(), Skills.class);
                List<Developer> developers1 = specialService.task3(skills);
                req.setAttribute("developers",developers1);
                req.setAttribute("skills",skills);
                req.getRequestDispatcher("/taskThree.jsp").forward(req,resp);
                break;
            case ("4"):
                Skills skills2= HandleBodyUtil.getModelFromStream(req.getInputStream(), Skills.class);
                List<Developer> developers2 = specialService.task4(skills2);
                req.setAttribute("developers",developers2);
                req.setAttribute("skills",skills2);
                req.getRequestDispatcher("/taskThree.jsp").forward(req,resp);
                break;

        }
    }
}
