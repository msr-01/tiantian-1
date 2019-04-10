package com.msr.dao;

import java.util.List;

import com.msr.bean.Category;

public interface CategoryDao {
	//加载所有的分类信息
	List<Category> findAll();
	
	//通过cid查询分类对象功能
	Category    findByCid(String cid);
}
