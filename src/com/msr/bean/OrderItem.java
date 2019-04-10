package com.msr.bean;
/**
 * 订单项实现对象
 * @author tom
 *
 */
public class OrderItem {
	private String itemid;	//	varchar(32)   订单项的编号
	private int quantity;	//	int(11)   订单项的数量
	private double total;	//	double	   对应购物车项中的“小计”
	private Product product;//	varchar(32) 关联商品对象 （1：1）
	private Orders order;//oid;//	varchar(32)			关联订单对象（N:1）
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(String itemid, int quantity, double total, Product product, Orders order) {
		super();
		this.itemid = itemid;
		this.quantity = quantity;
		this.total = total;
		this.product = product;
		this.order = order;
	}
}
