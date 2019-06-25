package com.wind.bean;

public class OrderItems {

	private Integer id;
	private String orderItemName;
	private Orders orders;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderItemName() {
		return orderItemName;
	}
	public void setOrderItemName(String orderItemName) {
		this.orderItemName = orderItemName;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "OrderItems [id=" + id + ", orderItemName=" + orderItemName + ", orders=" + orders + "]";
	}
	
}
