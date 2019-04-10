package com.msr.test;

import java.util.List;

import com.msr.bean.OrderItem;
import com.msr.bean.Orders;
import com.msr.bean.User;
import com.msr.dao.OrderDao;
import com.msr.dao.UserDao;
import com.msr.dao.impl.OrderDaoImpl;
import com.msr.dao.impl.UserDaoImpl;

public class OrderTest {
	public static void main(String[] args) {
		OrderDao orderDao = new OrderDaoImpl();
		UserDao userDao = new UserDaoImpl();
		User user  = userDao.login("liuwenjie", "123456");
		
		
		List<Orders> ordersList = orderDao.findByOrders(user);
		for(Orders o : ordersList) {
			System.out.println("=======订单号=========:"+o.getOid());
			for(OrderItem oi : o.getOrderItemList()) {
				System.out.println("商品图片："+oi.getProduct().getPimage());
				System.out.println("商品名称："+oi.getProduct().getPname());
				System.out.println("商品价格："+oi.getProduct().getShopPrice());
				System.out.println("商品数量："+oi.getQuantity());
				System.out.println("订单金额："+o.getTotal());
			}
		}
	}

}
