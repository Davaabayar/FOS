package edu.mum.cs.cs472.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.dao.Order;
import edu.mum.cs.cs472.dao.Role;
import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.OrderService;
import edu.mum.cs.cs472.util.DBConnection;

public class OrderServiceImpl implements OrderService {
	private DBConnection dbConnection;

	@Override
	public List<Order> getAllOrder() {
		String queryOrders = "select a.order_id,a.totalAmount,a.created,a.status,a.user_id," +
				"b.first_name,b.last_name,b.password,b.email,b.role,b.created as userCreated,b.image_id,b.address_id,b.status" +
				" from orders a INNER JOIN users b ON a.user_id=b.user_id";
		List<Order> orderList = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = this.getDbConnection().getConnection().prepareStatement(queryOrders);
			ResultSet resultOrder = preparedStatement.executeQuery();
			while (resultOrder.next()) {
				List<Food> foodList = new ArrayList<>();
				String queryOrderFoods = "select b.food_id,b.name,b.type,b.description,b.created,b.price,b.calories,b.image_id,b.order_count,c.path" +
						" from orders_has_foods a INNER JOIN foods b ON a.food_id=b.food_id LEFT JOIN images c ON c.image_id=b.image_id WHERE a.order_id=?";
				try {
					System.out.println(resultOrder.getString("order_id"));
					PreparedStatement preparedStatement2 = this.getDbConnection().getConnection().prepareStatement(queryOrderFoods);
					preparedStatement2.setString(1, resultOrder.getString("order_id"));
					ResultSet resultOrderFood = preparedStatement2.executeQuery();
					while (resultOrderFood.next()) {
						foodList.add(new Food(
								resultOrderFood.getInt("food_id"),
								resultOrderFood.getString("name"),
								resultOrderFood.getInt("calories"),
								resultOrderFood.getString("description"),
								resultOrderFood.getString("type"),
								resultOrderFood.getDouble("price"),
								resultOrderFood.getInt("image_id"),
								resultOrderFood.getString("path"),
								resultOrderFood.getInt("order_count"),
								new Date(resultOrderFood.getDate("created").getTime())
						));
					}
					System.out.println("Food List : ");
					System.out.println(foodList);

					orderList.add(new Order(
							resultOrder.getInt("order_id"),
							resultOrder.getInt("totalAmount"),
							new Date(resultOrder.getDate("created").getTime()),
							resultOrder.getInt("status"),
							new User(
									resultOrder.getInt("user_id"),
									resultOrder.getString("first_name"),
									resultOrder.getString("last_name"),
									resultOrder.getString("email"),
									(resultOrder.getString("role") == "client" ? Role.client : Role.admin),
									new Date(resultOrder.getDate("userCreated").getTime()),
									resultOrder.getInt("status"),
									resultOrder.getString("password")
							),
							foodList
					));

				} catch (SQLException e) {
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				}
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.getDbConnection().disconnect();
		}
		System.out.println(orderList);
		return orderList;
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
			
			PreparedStatement pstmt = this.getDbConnection().getConnection().prepareStatement(queryString);
			pstmt.setLong(1, newOrder.getTotalAmount());
			pstmt.setInt(2, newOrder.getStatus());
			pstmt.setLong(3, newOrder.getUser().getUser_id());
			
			int i = pstmt.executeUpdate();
			if (i != 0)
				return "SUCCESS";
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
