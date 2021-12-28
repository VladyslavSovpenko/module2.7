package ua.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.dao.DeveloperDao;

import ua.model.Developer;
import ua.server.LoginDTO;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final DeveloperDao developerDao = new DeveloperDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Here username and password are the names which I have given in the input box in Login.jsp page. Here I am retrieving the values entered by the user and keeping in instance variables for further use.

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        LoginDTO loginBean = new LoginDTO(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.

        loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
        loginBean.setPassword(password);

        try {
            Developer developer = developerDao.getByName(userName);
            if (developer != null && developer.getPassword() != null && developer.getPassword().equals(password)) {
                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("user", userName); //setting session attribute
                session.setMaxInactiveInterval(10 * 60);
                response.sendRedirect("main.jsp");
                request.setAttribute("userName", userName);

            } else {
                System.out.println("Error message = " + userName);
                request.setAttribute("errMessage", "User with name = " + userName + " not found");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

