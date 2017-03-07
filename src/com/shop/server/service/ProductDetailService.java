package com.shop.server.service;

import java.util.List;

import com.shop.server.model.Products;



public interface ProductDetailService {
	
	public List<Products> getAllProducts();
	public Products getProductById(int productid);
	public Products getProductByName(String productName);
	public List<Products> getPerishableProducts();
	public List<Products> getNonPerishableProducts();
	

}
