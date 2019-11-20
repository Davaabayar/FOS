package edu.mum.cs.cs472.service.impl;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.util.DBConnection;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class FoodServiceImpl implements FoodService {

    private DBConnection dbConnection;


    @Override
    public List<Food> getAllFood() {
        return null;
    }

    @Override
    public List<Food> getFoodById(int userId) {
        return null;
    }

    @Override
    public List<Food> getFoodByType(String type) {
        return null;
    }

    @Override
    public String newFood(Food newFood) {
        String queryString = "insert into fos.foods(name, type, description, created, price, calories, image_id) values (?,?,?,current_timestamp,?,?,?)";
//        String query = "insert into fos.foods(name, type, description, created, price, calories, image_id) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newFood.getName());
            preparedStatement.setString(2, newFood.getType());
            preparedStatement.setString(3, newFood.getDescription());
            preparedStatement.setString(4, Double.toString(newFood.getPrice()));
            preparedStatement.setString(5, Integer.toString(newFood.getCalories()));
            preparedStatement.setString(6, Integer.toString(newFood.getImage_id()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.getDbConnection().disconnect();
        }
        return "SUCCESS";
    }

    public DBConnection getDbConnection() {
        return dbConnection != null ? this.dbConnection : (this.dbConnection = new DBConnection());
    }
}
