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

@WebServlet("/taskthree")
public class TaskThree extends HttpServlet {

//    private static SpecialService specialService = SpecialService.getInstance();
//    Skills skills = new Skills();
//    List<Developer> list;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Object[] users = list.toArray();
//        req.setAttribute("developers", users);
//        req.setAttribute("skills", skills);
//        req.getRequestDispatcher("/jsp/taskThree.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.skills = HandleBodyUtil.getModelFromStream(req.getInputStream(), Skills.class);
//        this.list = specialService.task3(skills);
//
//    }
}
