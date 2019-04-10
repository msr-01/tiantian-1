package com.msr.bean;

import java.io.Serializable;

public class Product implements Serializable{
	private String pid;//	varchar(32)
	private String  pname;//varchar(50)
	private double  shopPrice;//double
	private String pimage;//varchar(200)
	private String pdate;//date
	private String pdesc;//varchar(255)
	private int pflag	;//int(11)  是否下架
	//分类的实体引用 
	private Category category;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getShopPrice() {
		return shopPrice;
	}
	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getPflag() {
		return pflag;
	}
	public void setPflag(int pflag) {
		this.pflag = pflag;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(String pid, String pname, double shopPrice, String pimage, String pdate, String pdesc, int pflag) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.shopPrice = shopPrice;
		this.pimage = pimage;
		this.pdate = pdate;
		this.pdesc = pdesc;
		this.pflag = pflag;
	}
	public Product(String pid, String pname, double shopPrice, String pimage, String pdate, String pdesc, int pflag,
			Category category) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.shopPrice = shopPrice;
		this.pimage = pimage;
		this.pdate = pdate;
		this.pdesc = pdesc;
		this.pflag = pflag;
		this.category = category;
	}

}
