package com.shop.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="orderdetails")
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid", nullable = false, unique = true)
	private int id;
	@Column(name="productid")
	private int prodId;
	@Column(name="contactid")
	private int contId;
	@Column(name="qty")
	private int qty;
	@Column(name="price")
	private int price;
	@Column(name="trackingno")
	private String trackNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public int getContId() {
		return contId;
	}
	public void setContId(int contId) {
		this.contId = contId;
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
	public String getTrackNo() {
		return trackNo;
	}
	public void setTrackNo(String trackNo) {
		this.trackNo = trackNo;
	}
	
}
