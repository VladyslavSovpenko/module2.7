package ua.servlets.developer;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.model.Developer;
import ua.service.DeveloperService;
import ua.service.HandleBodyUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;


@WebServlet("/developers/*")
public class ViewDevServlet extends HttpServlet {

    private static DeveloperService developerService = DeveloperService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(12);
        if ("new".equalsIgnoreCase(id)){
            req.setAttribute("developer", new Developer());
            req.setAttribute("isNew", true);

            req.getRequestDispatcher("/developer.jsp").forward(req, resp);
        }
        Optional<Developer> developerOptional = developerService.get(Long.parseLong(id));
        if (developerOptional.isPresent()) {
            Developer dev = developerOptional.get();
            req.setAttribute("developer", dev);
            req.getRequestDispatcher("/developer.jsp").forward(req, resp);
        }
        resp.sendRedirect("/developers");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Developer dev= HandleBodyUtil.getModelFromStream(req.getInputStream(),Developer.class);

        if (dev!=null){
            try {
                developerService.update(dev);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        resp.sendRedirect("/developers");
    }
}
