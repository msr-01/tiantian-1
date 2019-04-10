package com.msr.bean;

import java.io.Serializable;

/**
 * 分类实体
 * @author tom
 */
public class Category implements Serializable{
	private String cid;//	varchar(32)
	private String cname;//	varchar(20)
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

}	
