package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.service.impl.UserServiceImpl;
import edu.mum.cs.cs472.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register", description = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    public RegisterServlet() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegisterServlet: doPost");
//        String first_name = request.getParameter("first_name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        User newUser = new User();
//        newUser.setFirstName(first_name);
//        newUser.setEmail(email);
//        newUser.setPassword(password);
//        String regResult = newUser.registerUser(newUser);
//        if(regResult.equals("SUCCESS"))  {
//            System.out.println("Success");
//            request.getRequestDispatcher("home.jsp").forward(request, response);
//        } else {
//            System.out.println("Failure");
//            request.setAttribute("errMessage", userRegistered);
//            request.getRequestDispatcher("register").forward(request, response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("im here do get");
        request.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

}
