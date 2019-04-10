package com.msr.bean;
/**
 * 购物车
 * @author tom
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Cart {
	//1、总金额
	//2、购物车项   map  ——》  key：商品pid	value：购物车项
	private double total;
	private Map<String, CartItem> map = new HashMap<String, CartItem>();
	
	public void updateCart(String pid,int num) {
		CartItem oldCartItem = map.get(pid);
		oldCartItem.setNum(num);
	}
	
	//1、添加购物车
	public void addCart(CartItem cartItem) {
		String pid = cartItem.getProduct().getPid();//商品的pid
		if(map.containsKey(pid)) {//containsKey判断map中是否存在指定的key的名称
			//存在：改变购物车项中的数量
			//获取旧的对象
			CartItem oldCartItem = map.get(pid);
			// 5  +  3
			oldCartItem.setNum(oldCartItem.getNum() + cartItem.getNum());
		}else {
			//不存在：添加到购物车
			map.put(pid, cartItem);
		}
	}
	
	//2、删除购物车
	public void delCart(String pid) {
		total -= map.get(pid).getSubTotal();
		map.remove(pid);
	}
	
	//3、清空购物车
	public void clearCart() {
		total = 0.0;
		map.clear();
	}
	
	
	//获取总金额
	public double getTotal() {
		total = 0.0;
		//遍历map集体，取出所有的购物车项的小计，再进行累加操作
		for(CartItem  cartItem :  map.values()) {
			total +=cartItem.getSubTotal();
		}
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
}
