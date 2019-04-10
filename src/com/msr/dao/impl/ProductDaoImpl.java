package com.msr.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msr.bean.Category;
import com.msr.bean.Product;
import com.msr.dao.CategoryDao;
import com.msr.dao.ProductDao;
import com.msr.utils.DBHepler;

public class ProductDaoImpl implements ProductDao {

	// 查询指定分类的商品信息
	@Override
	public List<Product> findByCid(String cid) {
		try {
			List<Product> pList = new ArrayList<Product>();

			String sql = "select p.*,c.cname from product p,category c  where  p.cid = c.cid and p.cid = ? order by pdate desc";
			Object[] obj = { cid };
			ResultSet rs = DBHepler.getResultSet(sql, obj);
			while (rs.next()) {
				// 1、获取数据
				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				double shopPrice = rs.getDouble("shop_price");
				String pimage = rs.getString("pimage");
				String pdate = rs.getString("pdate");
				String pdesc = rs.getString("pdesc");
				int pflag = rs.getInt("pflag");
				String ccid = rs.getString("cid"); // 分类的编号 外键 2
				String cname = rs.getString("cname");
				// 2、把数据填充到对象上

				// 通过商品cid查询分类对象
				Category category = new Category(ccid, cname);

				Product product = new Product(pid, pname, shopPrice, pimage, pdate, pdesc, pflag, category);
				// 3、把对象添加到集合中
				pList.add(product);
			}

			return pList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product findByPid(String pid) {
		try {
			String sql = "select * from product where pid = ?";
			Object[] obj = { pid };
			ResultSet rs = DBHepler.getResultSet(sql, obj);
			if (rs.next()) {
				// 1、获取数据
				String ppid = rs.getString("pid");
				String pname = rs.getString("pname");
				double shopPrice = rs.getDouble("shop_price");
				String pimage = rs.getString("pimage");
				String pdate = rs.getString("pdate");
				String pdesc = rs.getString("pdesc");
				int pflag = rs.getInt("pflag");
				// 2、把数据填充到对象上
				Product product = new Product(pid, pname, shopPrice, pimage, pdate, pdesc, pflag);
				return product;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 分页方法
	 */
	@Override
	public List<Product> findByCidPage(String cid, int curPageSize,int everySize) {
		try {
			List<Product> pList = new ArrayList<Product>();

			String sql = "select p.*,c.cname \r\n" + 
					"from product p,category c  \r\n" + 
					"where  p.cid = c.cid and p.cid = ? order by pdate desc\r\n" + 
					"limit ?,?";
			
			//开始下标索引  = (当前页码-1)*每页大小;
			int beginIndex = (curPageSize - 1) * everySize;
			Object[] obj = { cid ,beginIndex,everySize};
			ResultSet rs = DBHepler.getResultSet(sql, obj);
			while (rs.next()) {
				// 1、获取数据
				String pid = rs.getString("pid");
				String pname = rs.getString("pname");
				double shopPrice = rs.getDouble("shop_price");
				String pimage = rs.getString("pimage");
				String pdate = rs.getString("pdate");
				String pdesc = rs.getString("pdesc");
				int pflag = rs.getInt("pflag");
				String ccid = rs.getString("cid"); // 分类的编号 外键 2
				String cname = rs.getString("cname");
				// 2、把数据填充到对象上

				// 通过商品cid查询分类对象
				Category category = new Category(ccid, cname);

				Product product = new Product(pid, pname, shopPrice, pimage, pdate, pdesc, pflag, category);
				// 3、把对象添加到集合中
				pList.add(product);
			}

			return pList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
