package com.shop.server.vo;



public class OrderVo {
	private int productid;
	private int contactid;
	private int qty;
	private int price;
	private String trackingno;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTrackingno() {
		return trackingno;
	}
	public void setTrackingno(String trackingno) {
		this.trackingno = trackingno;
	}
	
}
