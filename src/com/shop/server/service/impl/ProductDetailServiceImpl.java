package com.shop.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Products;
import com.shop.server.persistence.ProductDetailDao;
import com.shop.server.service.ProductDetailService;

@Service(value = "ProductDetailService")
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService {

	@Autowired
	private ProductDetailDao productDetailDao;
	
	@Override
	public List<Products> getAllProducts() {
		System.out.println("getAllProducts call started");
		List<Products> products=productDetailDao.getAllProducts();
		System.out.println("GetAllProducts returned -->"+products);
		return products;
	}

	@Override
	public Products getProductById(int productid) {
		System.out.println("getProductsById started  -- input-- "+productid);
		Products product=productDetailDao.getProductById(productid);
		System.out.println("getProductById returned --->"+product);
		return product;
	}

	@Override
	public Products getProductByName(String productName) {
		System.out.println("getProductsByName started  -- input-- "+productName);
		Products product=productDetailDao.getProductByName(productName);
		System.out.println("getProductByName returned --->"+product);
		return product;
	}

	@Override
	public List<Products> getPerishableProducts() {
		System.out.println("getPerishableProducts call started");
		List<Products> products=productDetailDao.getPerishableProducts();
		System.out.println("GetPerishableProducts returned -->"+products);
		return products;
	}

	@Override
	public List<Products> getNonPerishableProducts() {
		System.out.println("getNonPerishableProducts call started");
		List<Products> products=productDetailDao.getNonPerishableProducts();
		System.out.println("GetNonPerishableProducts returned -->"+products);
		return products;
	}
	

}
