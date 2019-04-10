package com.msr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.bean.Cart;
import com.msr.bean.CartItem;
import com.msr.bean.Product;
import com.msr.dao.ProductDao;
import com.msr.dao.impl.ProductDaoImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends BaseServlet {
	
	//修改购物车
	public String updateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收pid
		String pid = req.getParameter("pid");
		//调用购物车修改的方法
		Cart cart =(Cart)req.getSession().getAttribute("cart");
		int num = Integer.parseInt(req.getParameter("num"));//String ——>  int
		cart.updateCart(pid,num);
		//重新保存，刷新数据
		req.getSession().setAttribute("cart", cart);
		return "cart.jsp";
	}
	public String delCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收pid
		String pid = req.getParameter("pid");
		//调用购物车删除的方法
		Cart cart =(Cart)req.getSession().getAttribute("cart");
		cart.delCart(pid);
		//重新保存，刷新数据
		req.getSession().setAttribute("cart", cart);
		return "cart.jsp";
	}
	//添加购物车
	public String addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========CartServlet==========");
		
		//1、接收参数（pid、数量）
		String pid = req.getParameter("pid");
		int num = Integer.parseInt(req.getParameter("num"));//String ——>  int
		
		//2、通过pid获取商品对象
		ProductDao productDao = new ProductDaoImpl();
		Product product = productDao.findByPid(pid);
		
		//3、把商品添加到购物车项中
		CartItem cartItem = new CartItem(product,num);
		
		//判断购物车是否存在
		Cart cart = (Cart)req.getSession().getAttribute("cart");
		if(cart == null) {
			//如果cart == null，说明 session中没有保存cart对象
			cart = new Cart();
		}
		//4、把购物车项添加购物车
		cart.addCart(cartItem);
		
		//5、把购物车添加session
		req.getSession().setAttribute("cart", cart);
		
		return "cart.jsp";//6、跳转页面
	}
}
