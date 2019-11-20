package edu.mum.cs.cs472.service.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.mum.cs.cs472.dao.Order;
import edu.mum.cs.cs472.service.OrderService;
import edu.mum.cs.cs472.util.DBConnection;

public class OrderServiceImpl implements OrderService {
	private DBConnection dbConnection;

	@Override
	public List<Order> getAllOrder() {
		String queryString = "select user_id, first_name, last_name, email, role, created, image_id, address_id, status, password from users";

		return null;
	}

	@Override
	public List<Order> getOrderByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(int orderId) {
		// TODO Auto-generated method stub
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
