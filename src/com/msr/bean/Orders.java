package com.msr.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单对象  ——》购物车
 * @author tom
 *
 */
public class Orders {
	private String oid;//	varchar(32)  订单的编号
	private String ordertime;//	datetime 下单的时间
	private double total;//	double  关联“购物车”中的total属性
	private int state;//	int(11)  订单的状态：0：未付款  1：已付款
	private String address;//	varchar(30) //收货者地址
	private String name;//	varchar(20) 收货者姓名
	private String telephone;//	varchar(20) 收货者电话
	private User user;//	varchar(32) 关联“用户”对象 (1:1)
	
	//增加   订单 与 订单项的关联关系     1：N
	private  List<OrderItem> orderItemList = new ArrayList<OrderItem>();
	
	
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String oid, String ordertime, double total, int state, String address, String name, String telephone,
			User user) {
		super();
		this.oid = oid;
		this.ordertime = ordertime;
		this.total = total;
		this.state = state;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.user = user;
	}
	
}
