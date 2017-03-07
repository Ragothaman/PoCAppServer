package com.shop.server.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class OrderDetails {

	@Id
	@Column(name="productid", unique=true, nullable=false)
	private int productid;
	@Column(name="contactid", unique=true, nullable=false)
	private int contactid;
	@Column(name="qty", unique=true, nullable=false)
	private int qty;
	@Column(name="price", unique=true, nullable=false)
	private int price;
	@Column(name="trackingno", unique=true, nullable=false)
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
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "productid")
//	public Products getProducts() {
//		return products;
//	}
//	public void setProducts(Products products) {
//		this.products = products;
//	}
//	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "contactid")
//	public Contacts getContacts() {
//		return contacts;
//	}
//	public void setContacts(Contacts contacts) {
//		this.contacts = contacts;
//	}
//	private Products products;
//	private Contacts contacts;
	

	
}
