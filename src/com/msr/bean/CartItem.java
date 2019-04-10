package com.msr.bean;
/**
 * 购物车项:商品图片  商品名称   商品价格    数量     小计    
 * @author tom
 *
 */
public class CartItem {
	//商品对象（商品图片  商品名称   商品价格）   
	private Product product;
	private int num;//数量    
	private double subTotal;//小计    = 数量 * 单价 
	
	
	public CartItem(Product product, int num) {
		super();
		this.product = product;
		this.num = num;
	}

	public CartItem(Product product, int num, double subTotal) {
		super();
		this.product = product;
		this.num = num;
		this.subTotal = subTotal;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getSubTotal() {
		//小计    = 数量 * 单价 
		return subTotal = num * product.getShopPrice();
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
