package com.msr.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.msr.bean.Category;
import com.msr.bean.Product;
import com.msr.dao.CategoryDao;
import com.msr.dao.ProductDao;
import com.msr.dao.impl.CategoryDaoImpl;
import com.msr.dao.impl.ProductDaoImpl;

@WebListener
public class MyLisener implements ServletContextListener {
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	//当服务器开启时，加载分类信息，保存到服务器内存中
    	CategoryDao categoryDao = new CategoryDaoImpl();
    	//获取分类集合数据
    	List<Category> cList = categoryDao.findAll();
    	//把分类集合数据，保存到上下文中
    	sce.getServletContext().setAttribute("cList", cList);
    	
    	
    	/*//1、调用dao层
		ProductDao productDao = new ProductDaoImpl();
		List<Product> pList = productDao.findAllProducts();
		//2、保存数据
		sce.getServletContext().setAttribute("pList", pList);*/

		ProductDao productDao = new ProductDaoImpl();
		
		List<Product> pList1 =  productDao.findByCid("1");
		List<Product> pList2 =  productDao.findByCid("2");
		List<Product> pList3 =  productDao.findByCid("3");
		List<Product> pList4 =  productDao.findByCid("4");
		List<Product> pList5 =  productDao.findByCid("5");
		List<Product> pList6 =  productDao.findByCid("6");
		
		sce.getServletContext().setAttribute("pList1", pList1);
		sce.getServletContext().setAttribute("pList2", pList2);
		sce.getServletContext().setAttribute("pList3", pList3);
		sce.getServletContext().setAttribute("pList4", pList4);
		sce.getServletContext().setAttribute("pList5", pList5);
		sce.getServletContext().setAttribute("pList6", pList6);

		
    }
	
}
