package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.service.impl.UserServiceImpl;
import edu.mum.cs.cs472.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login", description = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    public LoginServlet() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.getAllUser();

        System.out.print("im here do get");

        System.out.print(userService.getAllUser().size());
    }
}
