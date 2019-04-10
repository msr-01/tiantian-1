package com.msr.dao;

import java.util.List;

import com.msr.bean.User;

/**
 *  用户接口
 * @author tom
 *
 */
public interface UserDao {
	//1、登录
	public User login(String username,String pwd);
	//2、注册 
	public boolean register(User user);
	//3、查询所有的用户列表
	public List<User> queryAallUser(String conditions);
	
}
