package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.impl.UserServiceImpl;
import edu.mum.cs.cs472.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout", description = "LogoutServlet")
public class LogoutServlet extends HttpServlet {


    public LogoutServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
        }
        //invalidate the session if exists
        HttpSession session = request.getSession();
        User loggedUser = (User) session.getAttribute("loggedUser");
        System.out.println(loggedUser.toString());
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
