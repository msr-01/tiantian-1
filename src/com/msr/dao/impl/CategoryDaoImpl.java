package com.msr.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msr.bean.Category;
import com.msr.dao.CategoryDao;
import com.msr.utils.DBHepler;

public class CategoryDaoImpl implements CategoryDao {

	//查询所有的分类
	@Override
	public List<Category> findAll() {
		List<Category> cList = new ArrayList<Category>();
		
		try {
			String sql = "select * from category";
			Object[] obj = {};
			ResultSet  rs =  DBHepler.getResultSet(sql, obj);
			//取数据
			while(rs.next()) {
				//获取字段的数据
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				//把数据填充到对象上
				Category  category = new Category(cid,cname);
				//把对象填充到集合中
				cList.add(category);
			}
				return cList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//通过cid，查询分类对象
	@Override
	public Category findByCid(String cid) {

		try {
			String sql = "select * from category where cid = ?";
			Object[] obj = {cid};
			ResultSet  rs =  DBHepler.getResultSet(sql, obj);
			//取数据
			if(rs.next()) {
				//获取字段的数据
				String ccid = rs.getString("cid");
				String cname = rs.getString("cname");
				//把数据填充到对象上
				Category  category = new Category(ccid,cname);
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
