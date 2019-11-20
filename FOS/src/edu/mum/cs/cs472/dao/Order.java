package edu.mum.cs.cs472.dao;

import java.sql.Date;

public class Order {
	private int orderId;
	private int totalAmount;
	private Date created;
	private int status;
	private User user;
	
	public Order() {
		super();
	}
	public Order(int orderId, int totalAmount, Date created, int status, User user) {
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.created = created;
		this.status = status;
		this.user = user;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalAmount=" + totalAmount + ", created=" + created + ", status="
				+ status + ", user=" + user + "]";
	}
	
	
	
}
