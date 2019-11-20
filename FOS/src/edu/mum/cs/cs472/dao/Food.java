package edu.mum.cs.cs472.dao;

public class Food {
    private String name;
    private String calories;
    private String description;
    private String type;
    private int foodId;


    public Food() {

    }

    public Food(String name,String calories, String description, String type) {
        this.name = name;
        this.calories = calories;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
