package ua.servlets.project;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Project;
import ua.service.HandleBodyUtil;
import ua.service.ProjectService;

import java.io.IOException;
import java.util.List;

@WebServlet("/projects")
public class ProjectServlet extends HttpServlet {

    private static ProjectService service = ProjectService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deleteId = req.getParameter("deleteId");
        if (deleteId!= null){
            Project project = new Project();
            project.setId(Long.parseLong(deleteId));
            service.delete(project);
        }

        List<Project> all = service.getAll();
        Object[] projects = all.toArray();
        req.setAttribute("projects", projects);
        req.getRequestDispatcher("projects.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Project project = HandleBodyUtil.getModelFromStream(req.getInputStream(), Project.class);
        service.create(project);
        resp.sendRedirect("/projects");
    }
}
