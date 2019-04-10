package com.msr.dao;

import java.util.List;

import com.msr.bean.OrderItem;
import com.msr.bean.Orders;
import com.msr.bean.User;

//接口
public interface OrderDao {
	//保存订单的方法
	public void saveOrder(Orders orders);
	//保存订单项的方法
	public void saveOrderItem(OrderItem orderItem);
	
	//根据用户查询指定的订单
	public List<Orders> findByOrders(User user);
}
