package com.msr.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.msr.bean.Product;
import com.msr.dao.ProductDao;
import com.msr.dao.impl.ProductDaoImpl;
import com.msr.utils.PageUtils;
import com.mysql.fabric.xmlrpc.base.Array;

public class ProductTest {
	public static void main(String[] args) {
		ProductDaoImpl productDaoImpl = new ProductDaoImpl();
		
		System.out.println(PageUtils.getTotalPageSize("2", 7));
		
		/*List<Product> pList = productDaoImpl.findByCidPage("1", 3, 3);
		
		for(Product p : pList) {
			System.out.println(p.getPid()+"\t"+p.getPname());
		}*/
		
		//System.out.println(product.getPname());
	}
}
