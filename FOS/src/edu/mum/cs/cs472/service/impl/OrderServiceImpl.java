package edu.mum.cs.cs472.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.dao.Image;
import edu.mum.cs.cs472.dao.Item;
import edu.mum.cs.cs472.dao.Order;
import edu.mum.cs.cs472.service.OrderService;
import edu.mum.cs.cs472.util.DBConnection;

public class OrderServiceImpl implements OrderService {
	private DBConnection dbConnection;

	@Override
	public List<Order> getAllOrder() {
		return null;
	}

	@Override
	public List<Order> getOrderByUserId(int userId) {
		return null;
	}

	@Override
	public Order getOrderById(int orderId) {
		return null;
	}

	@Override
	public String addOrder(Order newOrder) {
		System.out.println("OrderServiceImpl.addOrder order object=>" + newOrder.toString());
		try {			
			String queryString = "insert into fos.orders(totalAmount, status, created , user_id) values (?,?,current_timestamp,?)";
			PreparedStatement pstmt = this.getDbConnection().getConnection().prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
			pstmt.setLong(1, newOrder.getTotalAmount());
			pstmt.setInt(2, newOrder.getStatus());
			pstmt.setLong(3, newOrder.getUser().getUser_id());
			pstmt.executeUpdate();
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int insertedId = generatedKeys.getInt(1);
                    System.out.println("Generated key" + insertedId);
                    
                    if(newOrder.getItems()!=null) {
    					List<Item> items = newOrder.getItems();
    					for (Item item : items) {
    						String insertOrderedFood = "insert into fos.orders_has_foods(order_id, food_id, quantity) values (?,?,?)";
    						PreparedStatement insertPstmt = this.getDbConnection().getConnection().prepareStatement(insertOrderedFood);
    						insertPstmt.setLong(1, insertedId);
    						insertPstmt.setInt(2, item.getFood().getFoodId());
    						insertPstmt.setInt(3, item.getQuantity());
    						insertPstmt.executeUpdate();
        				}
                    }
    				return "SUCCESS";
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
			
		} catch (SQLException e) {
			System.err.println(e);
		}
		return "Oops.. Something went wrong there..!";
	}

	public DBConnection getDbConnection() {
		return dbConnection != null ? this.dbConnection : (this.dbConnection = new DBConnection());
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
}
