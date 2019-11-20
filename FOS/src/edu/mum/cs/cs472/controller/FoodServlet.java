package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodServlet", urlPatterns = "/food", description = "FoodServlet")
public class FoodServlet extends HttpServlet {
    private FoodService foodService;

    public FoodServlet() {
        foodService = new FoodServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodName = request.getParameter("foodName");
        String calories = request.getParameter("calories");
        String foodType = request.getParameter("foodType");
        String description = request.getParameter("description");
        String imageId = request.getParameter("image");
        String price = request.getParameter("price");
        System.out.println("["+foodName+","+calories+","+foodType+","+description+","+imageId+","+price+"]");

        Food newFood = new Food(foodName,Integer.parseInt(calories),description,foodType,Double.parseDouble(price),Integer.parseInt(imageId));

        String regResult = this.foodService.newFood(newFood);
        if(regResult.equals("SUCCESS"))  {
            System.out.println("Success");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            System.out.println("Failure");
            request.setAttribute("errMessage", regResult);
            System.out.println(regResult);
            request.getRequestDispatcher("food.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
