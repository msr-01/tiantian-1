package com.msr.dao;

import java.util.List;

import com.msr.bean.Product;

public interface ProductDao {
	//根据cid查询指定分类的商品的方法 
	List<Product> findByCid(String cid);

	//根据商品编号，查找商品的对象
	Product findByPid(String pid);
	
	/**
	 * 以分页方法来显示商品的信息
	 * @param cid			分类编号
	 * @param curPageSize	当前页码
	 * @param everySize		每页显示的大小
	 * @return
	 */
	List<Product> findByCidPage(String cid,int curPageSize,int everySize);
}
