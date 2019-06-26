package com.wind.dao;

import com.wind.bean.OrderItems;

public interface OrderItemsMapper {

	// 要求：查询订单项信息的时候，将订单项所属的订单信息查出来
	public OrderItems getOrderItemsById(Integer id);
	
}
