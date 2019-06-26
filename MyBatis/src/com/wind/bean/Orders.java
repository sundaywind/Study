package com.wind.bean;

import java.util.List;

public class Orders {
	
	private Integer id;
	private String orderName;
	private List<OrderItems> list;
	
	public List<OrderItems> getList() {
		return list;
	}
	public void setList(List<OrderItems> list) {
		this.list = list;
	}
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
		return "Orders [id=" + id + ", orderName=" + orderName + ", list=" + list + "]";
	}
	
}
