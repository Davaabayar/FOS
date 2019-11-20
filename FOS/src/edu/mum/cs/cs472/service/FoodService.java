package edu.mum.cs.cs472.service;

import edu.mum.cs.cs472.dao.Food;

import java.util.List;

public interface FoodService {
    public List<Food> getAllFood();

    public List<Food> getFoodById(int userId);

    public List<Food> getFoodByType(String type);

    public String newFood(Food newFood);
}
