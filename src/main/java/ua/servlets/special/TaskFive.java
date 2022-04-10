package ua.servlets.special;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.ProjectList;
import ua.service.SpecialService;

import java.io.IOException;
import java.util.List;

@WebServlet("/taskfive")
public class TaskFive extends HttpServlet {

//    private static SpecialService specialService = SpecialService.getInstance();

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<ProjectList> projectLists = specialService.task5();
//        Object[] objects = projectLists.toArray();
//        req.setAttribute("list",objects);
//        req.getRequestDispatcher("/jsp/taskFive.jsp").forward(req,resp);
//    }
}
