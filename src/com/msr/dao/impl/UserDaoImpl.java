package com.msr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.bean.User;
import com.msr.dao.UserDao;
import com.msr.utils.DBHepler;
/**
 * 用户实现类
 * @author tom
 */
public class UserDaoImpl implements UserDao{

	//登录功能
	@Override
	public User login(String username, String pwd) {
		//1、定义三个接口
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//2、实现化三个接口
		try {
			conn = DBHepler.getConn();
			ps = conn.prepareStatement("select * from user where username=? and password=?");
			//处理问号传值
			ps.setString(1, username);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			//3、读取数据
			if(rs.next()) {
				//获取数据库中user表里面的字段值
				String uid = rs.getString("uid");
				String uname = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String birthday = rs.getString("birthday");
				String sex = rs.getString("sex");
				User user = new User(uid, uname, password, name, email, telephone, birthday, sex);
				
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHepler.getClose(conn, ps, rs);
		}
		return null;
	}

	//注册
	@Override
	public boolean register(User user) {
		String sql = "insert into user values (?,?,?,?,?,?,?,?)";
		Object[] obj = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex()};
		return DBHepler.common(sql, obj);
	}
	//3、查询所有的用户列表
	@Override
	public List<User> queryAallUser(String conditions) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user where 1=1 "+conditions;
		System.out.println("sql:"+conditions);
		
		Object[] obj = {};
		ResultSet rs = DBHepler.getResultSet(sql, obj);
		try {
			while(rs.next()) {
				//获取数据库中user表里面的字段值
				String uid = rs.getString("uid");
				String uname = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String birthday = rs.getString("birthday");
				String sex = rs.getString("sex");
				
				User user = new User(uid, uname, password, name, email, telephone, birthday, sex);
				userList.add(user);
			}
				return userList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
