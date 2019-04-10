package com.msr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.bean.Product;
import com.msr.dao.ProductDao;
import com.msr.dao.impl.ProductDaoImpl;
import com.msr.utils.PageUtils;

@WebServlet(urlPatterns = "/ProductServlet",initParams = {@WebInitParam(name="everySize",value="10")})
public class ProductServlet extends BaseServlet {
	
	//分页的方法
	public String findByCidPage(HttpServletRequest request, HttpServletResponse response) {
		
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		
		ProductDao productDao = new ProductDaoImpl();
		
		
		//定义当前页码
		int curPageSize =Integer.parseInt(request.getParameter("curPageSize"));
		//定义每页显示的大小
		int everySize = Integer.parseInt(this.getServletConfig().getInitParameter("everySize"));
		//获取总页码
		int totalPageSize = PageUtils.getTotalPageSize(cid, everySize);
		
		//处理边界问题
		if(curPageSize<=1) {
			curPageSize = 1;
		}else if(curPageSize>=totalPageSize) {
			curPageSize = totalPageSize;
		}
		
		List<Product> pList = productDao.findByCidPage(cid, curPageSize, everySize);
		
		//保存数据
		request.getSession().setAttribute("pList", pList);
		request.getSession().setAttribute("cname", cname);
		//保存当前页码
		request.getSession().setAttribute("curPageSize", curPageSize);
		//保存总页码
		request.getSession().setAttribute("totalPageSize", totalPageSize);
		
		
		
		return "list.jsp";
	}
	
	
	//根据商品的编号查找指定的商品
	public String findByPid(HttpServletRequest request, HttpServletResponse response) {
		//接收数据
		String pid = request.getParameter("pid");
		String cname = request.getParameter("cname");
		
		//调用dao层
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.findByPid(pid);//pid = 1
		//保存数据
		request.getSession().setAttribute("product", product);
		request.getSession().setAttribute("cname", cname);
		
		return "detail.jsp";
	}
	
	//查询指定分类的商品信息
	public String findByCid(HttpServletRequest request, HttpServletResponse response) {
		//接收cid的参数值
		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		
		ProductDao productDao = new ProductDaoImpl();
		List<Product> pList = productDao.findByCid(cid);
		
		//保存数据
		request.getSession().setAttribute("pList", pList);
		request.getSession().setAttribute("cname", cname);
		
		
		//3、页面跳转
		return "list.jsp";
	}
	
	
	
}
