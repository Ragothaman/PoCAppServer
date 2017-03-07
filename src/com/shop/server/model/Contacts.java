package com.shop.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contactdetails")
public class Contacts {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private int id;
	@Column(name="name", unique=false, nullable=false)
	private String name;
	@Column(name="contactno", unique=false, nullable=false)
	private String contactno;
	@Column(name="geoloc", unique=false, nullable=false)
	private String geoloc;
	@Column(name="state", unique=false, nullable=false)
	private String state;
	@Column(name="country", unique=false, nullable=false)
	private String country;
	@Column(name="pincode", unique=false, nullable=false)
	private String pincode;
	@Column(name="address", unique=false, nullable=false)
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getGeoloc() {
		return geoloc;
	}
	public void setGeoloc(String geoloc) {
		this.geoloc = geoloc;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

}
