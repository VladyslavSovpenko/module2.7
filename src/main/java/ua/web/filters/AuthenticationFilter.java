package ua.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session=req.getSession(false);
        if ((session == null || session.getAttribute("user")==null)
                && !"login.jsp".equalsIgnoreCase(req.getRequestURI())) {

            req.getRequestDispatcher("login.jsp").forward(request,response);
        }
        chain.doFilter(request, response);
    }
}
