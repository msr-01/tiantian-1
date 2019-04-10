package com.msr.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msr.bean.User;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter(filterName =  "/MyFilter",urlPatterns = "/*")
public class MyFilter implements Filter {
    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("======doFilter========");
		//转换请求与响应对象
		HttpServletRequest  req = (HttpServletRequest)request;//请求
		HttpServletResponse resp = (HttpServletResponse)response;//响应
		HttpSession session = req.getSession();//会话对象
		
		String url = req.getRequestURI(); //请求路径
		//http://localhost:8080/tiantian/aaa.jsp    //  -1
		
		List<String> pathList = new ArrayList<String>();
		pathList.add("user_center_info.jsp");
		pathList.add("user_center_site.jsp");
		pathList.add("user_center_order.jsp");
		pathList.add("place_order.jsp");
		pathList.add("cart.jsp");
		pathList.add("CartServlet");
		
		//判断用户是否登录，如果登录了，其它页面都放权,如果没有登录，则跳转到登录页面
		User user = (User)session.getAttribute("user");
		if(user!=null) {
			//登录
			chain.doFilter(request, response);//放权
			return;
		}else {
			//未登录
			for(String path : pathList) {
				if(url.indexOf(path) !=-1) {
					resp.sendRedirect("login.jsp");
					return;
				}
			}
		}
		//如果没有登录，并且不是执行权限页面，其它页面可以放权
		chain.doFilter(request, response);//放权
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("=======MyFilter=========");
	}

}
