package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodServlet", urlPatterns = "/food", description = "FoodServlet")
public class FoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodName = request.getParameter("foodName");
        String calories = request.getParameter("calories");
        String foodType = request.getParameter("foodType");
        String description = request.getParameter("description");
        String imageId = request.getParameter("image");
        System.out.println("["+foodName+","+calories+","+foodType+","+description+","+imageId+"]");

        Food newFood = new Food(foodName,calories,foodType,description);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
