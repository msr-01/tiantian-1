package com.msr.utils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msr.bean.Category;
import com.msr.bean.Product;

/**
 * 分页的工具类
 * @author tom
 *
 */
public class PageUtils {
	//获取总记录数
	public static int getTotalSize(String cid) {
		try {
			List<Product> pList = new ArrayList<Product>();
			String sql = "select count(*)\r\n" + 
					"from product p,category c  \r\n" + 
					"where  p.cid = c.cid and p.cid = ? order by pdate desc";
			
			//开始下标索引  = (当前页码-1)*每页大小;
			Object[] obj = { cid};
			ResultSet rs = DBHepler.getResultSet(sql, obj);
			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//获取总页数
	public static int getTotalPageSize(String cid,int everySize) {
		int totalSize = getTotalSize(cid);//总记录
		//计算总页数      =  总记录数 / 每页显示的大小
		//计算结果如果能除断，就直接除，如果有余数，就+1
		
		if(totalSize % everySize ==0) {
			return totalSize /everySize;
		}else {
			return totalSize /everySize +1;
		}
		//return  totalSize % everySize ==0 ? totalSize /everySize  : totalSize /everySize+1 ;
	}
}
