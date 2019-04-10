package com.msr.dao.impl;

import com.msr.bean.Orders;
import com.msr.bean.Product;
import com.msr.bean.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msr.bean.OrderItem;
import com.msr.dao.OrderDao;
import com.msr.utils.DBHepler;
/**
 * 实现类
 * @author tom
 *
 */
public class OrderDaoImpl implements OrderDao {
	//保存订单
	@Override
	public void saveOrder(Orders orders) {
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		Object[] obj = {orders.getOid(),orders.getOrdertime(),orders.getTotal(),orders.getState(),orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getUser().getUid()};
		DBHepler.common(sql, obj);
	}

	//保存订单项
	@Override
	public void saveOrderItem(OrderItem orderItem) {
		String sql = "insert into orderitem values(?,?,?,?,?)";
		Object[] obj = {orderItem.getItemid(),orderItem.getQuantity(),orderItem.getTotal(),orderItem.getProduct().getPid(),orderItem.getOrder().getOid()};
		DBHepler.common(sql, obj);
	}

	//查询所有的订单对象
	@Override
	public List<Orders> findByOrders(User user) {
		List<Orders> ordersList = new ArrayList<Orders>();
		
		String sql = "select * from orders where uid=? order by ordertime desc";
		Object[] obj = {user.getUid()};
		
		ResultSet rs = DBHepler.getResultSet(sql, obj);

		try {
			while(rs.next()) {
				String oid = rs.getString("oid");
				String ordertime = rs.getString("ordertime");
				double total = rs.getDouble("total");
				int state = rs.getInt("state");
				String address = rs.getString("address");
				String name = rs.getString("name");
				String telephone = rs.getString("telephone");
				String uid = rs.getString("uid");
				
				//创建订单对象
				Orders orders = new Orders();
				orders.setAddress(address);
				orders.setName(name);
				orders.setOid(oid);
				orders.setOrdertime(ordertime);
				orders.setState(state);
				orders.setTelephone(telephone);
				orders.setTotal(total);
				orders.setUser(user);
				
				//遍历订单项数据,发送sql语法
				String product_item_sql = "select * from orderitem o,product p where o.pid = p.pid and o.oid =?";
				Object[]  product_item_obj = {oid};
				ResultSet product_item_rs = DBHepler.getResultSet(product_item_sql, product_item_obj);
				while(product_item_rs.next()) {
					//获取商品数据
					String pid = product_item_rs.getString("pid");
					String pname = product_item_rs.getString("pname");
					double shopPrice = product_item_rs.getDouble("shop_price");
					String pimage = product_item_rs.getString("pimage");
					String pdate = product_item_rs.getString("pdate");
					String pdesc = product_item_rs.getString("pdesc");
					int pflag = product_item_rs.getInt("pflag");
				
					
					//创建商品对象并且给商品对象赋值
					Product product = new Product(pid, pname, shopPrice, pimage, pdate, pdesc, pflag);
					
					
					//获取订单项的数据
					String itemid = product_item_rs.getString("itemid");
					int quantity = product_item_rs.getInt("quantity");
					double totals = product_item_rs.getDouble("total");
					String pids = product_item_rs.getString("pid");
					String oids = product_item_rs.getString("oid");
					
					//创建订单项对象
					OrderItem orderItem = new OrderItem();
					orderItem.setItemid(itemid);
					orderItem.setOrder(orders);//把订单传递给订单项
					orderItem.setProduct(product);//把商品对象传递给订单项
					orderItem.setQuantity(quantity);
					orderItem.setTotal(totals);
					
					//把订单项添加到订单的集合中
					orders.getOrderItemList().add(orderItem);
				}
				
				
				//把对象添加到集合
				ordersList.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ordersList;
	}

}
