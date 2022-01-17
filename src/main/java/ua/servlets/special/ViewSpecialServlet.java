package ua.servlets.special;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ua.service.SpecialService;

import java.io.IOException;

@WebServlet("/special/*")
public class ViewSpecialServlet extends HttpServlet {

    private static SpecialService specialService = SpecialService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String choose = req.getParameter("choose");
        switch (choose) {
            case ("1"):
              req.getRequestDispatcher("taskOne.jsp").forward(req,resp);
              break;
        }
    }
}
