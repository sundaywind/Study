package com.wind.dao;

import java.util.List;

import com.wind.bean.Orders;

public interface OrdersMapper {

	// 测试分步查询
	public List<Orders> getOrderById(Integer id);
	// 要求：查询订单信息的时候，将该订单下的所有订单项信息查出来。
	public List<Orders> getOrdersWithOrderItemsByOrderid(Integer id);
	// 分步查询
	public List<Orders> getOrdersWithOrderItemsDuiDuo(Integer id);
}
