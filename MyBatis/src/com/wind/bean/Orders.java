package com.wind.bean;

public class Orders {
	
	private Integer id;
	private String orderName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderName=" + orderName + "]";
	}
	
}
