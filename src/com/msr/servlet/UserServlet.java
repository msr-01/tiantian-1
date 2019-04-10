package com.msr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msr.bean.User;
import com.msr.dao.UserDao;
import com.msr.dao.impl.UserDaoImpl;
import com.msr.utils.MyBeanUtils;
import com.msr.utils.UUIDUtils;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	UserDao userDao = null;//定义dao层对象
	//查询所有的用户列表
	public String queryAallUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("==========queryAallUser=============");
		
		//接收数据（两个时间、用户名）
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		String username = req.getParameter("username");
		
		//接收动态条件的变量
		String conditions = "";
		//判断接收的数据是否有值，如果有值，则拼接sql语句
		if((!"".equals(start) && start!=null) ||  (!"".equals(end) && end!=null )) {
			conditions = conditions + " and birthday between '"+start+"' and '"+end+"' ";
		}
		
		if(!"".equals(username) && username!=null) {
			conditions = conditions + " and name = '"+username+"'";
		}
		
		//访问dao层加载数据, List<User>  queryAallUser();
		List<User> userList = userDao.queryAallUser(conditions);
		
		
		req.getSession().setAttribute("userList", userList);
		
		return "admin/member-list.jsp";
	}
	
	@Override
	public void init() throws ServletException {
		userDao = new UserDaoImpl();
	}
	
	//登录功能
	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//2、获取数据
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		//3、调用dao层
		
		User user = userDao.login(username, pwd);
		if(user!=null) {
			//登录成功
			//4、保存数据   
			HttpSession session =  req.getSession();
			session.setAttribute("user", user);
			//5、页面跳转
			//resp.sendRedirect("index.jsp");
			return "index.jsp";
		}else {
			//登录失败
			//5、页面跳转
			//resp.sendRedirect("login.jsp");
			return "login.jsp";
		}
	
	}
	
	//注册功能
	public String register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//注册
		//2、获取数据
		User user = MyBeanUtils.populate(User.class, req.getParameterMap());
		//处理未传递的数据uid
		user.setUid(UUIDUtils.getId());
		
		boolean flag = userDao.register(user);
		
		if(flag) {
			//4、保存数据(省略)
			//5、页面跳转(注册成功,跳转到登录页面)
			//resp.sendRedirect("login.jsp");
			return "login.jsp";
		}else {
			//5、页面跳转(注册成功,跳转到当前页面)
			//resp.sendRedirect("register.jsp");
			return "register.jsp";
		}
	
	}
	
	//注销功能
	public String logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//注销功能   把session对象的内容清空
		req.getSession().removeAttribute("user");
		//页面跳转   login.jsp
		//resp.sendRedirect("login.jsp");
		return "login.jsp";
	}
}
