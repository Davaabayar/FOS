package edu.mum.cs.cs472.dao;

public class Food {
    private int foodId;

    private String name;
    private int calories;
    private String description;
    private String type;
    private double price;
    private int image_id;



    public Food() {

    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public Food(String name, int calories, String description, String type, double price, int image_id) {
        this.name = name;
        this.calories = calories;
        this.description = description;
        this.type = type;
        this.price = price;
        this.image_id = image_id;
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
