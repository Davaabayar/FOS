package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/123", description = "IndexServlet")
public class IndexServlet extends HttpServlet {
    private FoodService foodService;
    public IndexServlet() {
        foodService = new FoodServiceImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("asd");
        List<Food> foodList = foodService.getAllFood();
        System.out.println(foodList.get(0).getImage_path());
        request.setAttribute("foodList", foodList);
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
