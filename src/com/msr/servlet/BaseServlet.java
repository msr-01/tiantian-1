package com.msr.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 公共的serlvet对象
 * @author ZHG
 *1、获取公用数据
 *2、获取指定的class
 *3、动态执行对应的方法（反射）
 *4、页面转发
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
	public BaseServlet() {
		System.out.println("BaseServlet构造方法");
	}
	
	//处理业务逻辑  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=======BaseServlet=======");
		//1、设置中文乱码处理
		request.setCharacterEncoding("UTF-8");
		//2、获取method参数
		String method = request.getParameter("method");//logout
		//判断method是否有值
		if(method==null || method.equals("") || method.trim().equals("")) {
			method = "execute";
		}else {
			try {
				//method不为空 (UsersServlet)   
				//3、获取对象的class:this代表正在访问的子类servlet对象
				Method md =  this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
				//4、执行方法
				String path = (String)md.invoke(this, request,response);  ///login.jsp
				System.out.println("path:"+path);
				//判断path是否为null
				if(path==null) {
					System.out.println("跳转路径为空，请检查！");
				}else {
					//页面跳转(转发)
					request.getRequestDispatcher(path).forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	//给子类用于重写，实现无参数传递的模块操作
	protected String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return null;
	}
}
