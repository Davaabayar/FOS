package edu.mum.cs.cs472.service.impl;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodServiceImpl implements FoodService {

    private DBConnection dbConnection;


    @Override
    public List<Food> getAllFood() {
        String queryString = "select a.food_id, a.name, a.type, a.description, a.created, a.price, a.calories, a.image_id, a.order_count, b.path from foods a LEFT JOIN images b ON a.image_id = b.image_id";

        List<Food> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Food(
                        resultSet.getString("name"),
                        resultSet.getInt("calories"),
                        resultSet.getString("description"),
                        resultSet.getString("type"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("image_id"),
                        resultSet.getString("path"),
                        resultSet.getInt("order_count"),
                        new Date(resultSet.getDate("created").getTime())
                ));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.getDbConnection().disconnect();
        }
        System.out.println("ALL FOOD ");
        System.out.println(list);
        return list;
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
