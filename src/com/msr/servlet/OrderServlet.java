package com.msr.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.bean.Cart;
import com.msr.bean.CartItem;
import com.msr.bean.OrderItem;
import com.msr.bean.Orders;
import com.msr.bean.User;
import com.msr.dao.OrderDao;
import com.msr.dao.impl.OrderDaoImpl;
import com.msr.utils.UUIDUtils;


@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	//查询指定用户下的所有订单
	public String findByOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=========findByOrder========");
		OrderDao orderDao = new OrderDaoImpl();
		//从session中获取登录的user
		User user =(User)req.getSession().getAttribute("user");
		List<Orders> orderList = orderDao.findByOrders(user);
		//保存集合
		req.getSession().setAttribute("orderList", orderList);
		
		return "user_center_order.jsp";
	}
	
	//保存订单
	public String saveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收参数 
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String telephone = req.getParameter("telephone");
		
		
		//调用dao层的保存方法
		OrderDao orderDao = new OrderDaoImpl();
		// 创建订单对象
		Orders orders = new Orders();
		//对订单对象赋值
		orders.setAddress(address);
		orders.setName(name);
		orders.setTelephone(telephone);
		orders.setOid(UUIDUtils.getId());
		//把Date类型的时间，转换为String类型的时间
		String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		orders.setOrdertime(strDate);
		orders.setState(0);//未付款
		 //从session中获取购物车对象的 total属性   key :cart
		Cart cart = (Cart)req.getSession().getAttribute("cart");
		orders.setTotal(cart.getTotal()); 
		User user = (User)req.getSession().getAttribute("user");//从session中获取user对象
		orders.setUser(user);  
		
		//处理订单项集合的赋值操作,订单项关联的是购物车，只要读取购物车项的数据，就可以填充到订单项中去
		//遍历购物车map集合，依次获取购物车项的对象
		for(CartItem cartItem : cart.getMap().values()) {
			//每次循环产生订单项对象
			OrderItem orderItem = new OrderItem();
			//给订单项赋值
			orderItem.setItemid(UUIDUtils.getId());
			orderItem.setProduct(cartItem.getProduct());//把购物车项中的商品对象给订单项
			orderItem.setQuantity(cartItem.getNum()); //把购物车项中的数量给订单项
			orderItem.setTotal(cartItem.getSubTotal());//小计
			orderItem.setOrder(orders);	//把订单对象给订单项
			
			//给订单集合对象添加元素
			orders.getOrderItemList().add(orderItem);
		}
		
		//保存订单及订单项 
		saveOrderAndOrderItem(orders,req,resp);
		return "OrderServlet?method=findByOrder";
	}
	
	//保存订单及订单项
	public String saveOrderAndOrderItem(Orders orders,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OrderDao orderDao = new OrderDaoImpl();
		//保存"订单"数据
		orderDao.saveOrder(orders);   //30
		//保存"订单项"数据
		//遍历“订单”的集合数据，依次保存“订单项”
		for(OrderItem  oi : orders.getOrderItemList()) {
			orderDao.saveOrderItem(oi);
		}
		return null;
	}
}
