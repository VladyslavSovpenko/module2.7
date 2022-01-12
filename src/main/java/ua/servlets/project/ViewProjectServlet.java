package ua.servlets.project;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Project;
import ua.service.HandleBodyUtil;
import ua.service.ProjectService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

@WebServlet("/projects/*")
public class ViewProjectServlet extends HttpServlet {

    private static Gson gson = new Gson();
    private final ProjectService service = ProjectService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(10);
        if("new".equalsIgnoreCase(id)){
            req.setAttribute("project", new Project());
            req.setAttribute("isNew", true);
            req.getRequestDispatcher("/project.jsp").forward(req,resp);
        }

        Optional<Project> projectOptional = service.get(Long.parseLong(id));
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            req.setAttribute("project", project);
            req.getRequestDispatcher("/project.jsp").forward(req, resp);
        }
        resp.sendRedirect("/projects");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Project project = HandleBodyUtil.getModelFromStream(req.getInputStream(), Project.class);
        Optional<Project> projectOptional = service.get(project.getId());
        project.setDate(projectOptional.get().getDate());
            if (project != null) {
                service.update(project);
            }
            resp.sendRedirect("/projects");

        }
}
