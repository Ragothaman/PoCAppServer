package com.shop.server.persistence;

import java.util.List;

import com.shop.server.model.Products;

public interface ProductDetailDao {
	
	public List<Products> getAllProducts();
	public Products getProductById(int productid);
	public Products getProductByName(String productName);
	public List<Products> getPerishableProducts();
	public List<Products> getNonPerishableProducts();
	
}
