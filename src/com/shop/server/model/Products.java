/**
 * 
 */
package com.shop.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author BMGDX
 *
 */
@Entity
@Table(name="products")
public class Products {
	
	@Id
	@Column(name="productid", unique=true, nullable=false)
	private int productid;
	@Column(name="productname", unique=true, nullable=false)
	private String productname;
	@Column(name="perishable", unique=false, nullable=false)
	private String perishable;
	@Column(name="price", unique=false, nullable=false)
	private int price;
	@Column(name="productdesc", unique=false, nullable=true)
	private String productdesc;
	@Column(name="imagename", unique=false, nullable=false)
	private String imagename;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPerishable() {
		return perishable;
	}
	public void setPerishable(String perishable) {
		this.perishable = perishable;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	
	
	

}
