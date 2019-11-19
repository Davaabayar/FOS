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
        //Copying all the input parameters in to local variables
//        String first_name = request.getParameter("first_name");
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//
//        User user = new User();
//        //Using Java Beans - An easiest way to play with group of related data
//        user.setFirstName;
//        user.setEmail(email);
//        user.setUserName(userName);
//        user.setPassword(password);
//
//        UserDAO userDAO = new UserDAO();
//
//        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
//        String userRegistered = userDAO.registerUser(userBean);
//
//        if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
//        {
//            request.getRequestDispatcher("/Home.jsp").forward(request, response);
//        }
//        else   //On Failure, display a meaningful message to the User.
//        {
//            request.setAttribute("errMessage", userRegistered);
//            request.getRequestDispatcher("/Register.jsp").forward(request, response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print("im here do get");

        System.out.print(userService.getAllUser());
    }

}
