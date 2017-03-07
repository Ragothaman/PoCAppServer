package com.shop.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.server.model.Products;
import com.shop.server.service.ProductDetailService;
import com.shop.server.vo.ProductVo;


@RestController
public class ProductController {
	@Autowired
	private ProductDetailService productDetailService;
	
	@RequestMapping(value = "/products/getallproducts", method = RequestMethod.POST)
	public ResponseEntity<List<Products>> getAllProducts() {
		System.out.println("GetAllProducts ");
		List<Products> product = productDetailService.getAllProducts();
		return new ResponseEntity<List<Products>>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/getproductbyid", method = RequestMethod.POST)
	public ResponseEntity<Products> getProductById(@RequestBody ProductVo productVo) {
		System.out.println("GetProductsById ");
		int productId=productVo.getProductid();
		Products product = productDetailService.getProductById(productId);
		return new ResponseEntity<Products>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/getproductbyname", method = RequestMethod.POST)
	public ResponseEntity<Products> getProductByName(@RequestBody ProductVo productVo) {
		System.out.println("GetProductsByName ");
		String productName=productVo.getProductname();
		Products product = productDetailService.getProductByName(productName);
		return new ResponseEntity<Products>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/getperishableproducts", method = RequestMethod.POST)
	public ResponseEntity<List<Products>> getPerishableProducts() {
		System.out.println("GetPerishableProducts ");
		List<Products> product = productDetailService.getPerishableProducts();
		return new ResponseEntity<List<Products>>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products/getnonperishableproducts", method = RequestMethod.POST)
	public ResponseEntity<List<Products>> getNonPerishableProducts() {
		System.out.println("GetNonPerishableProducts ");
		List<Products> product = productDetailService.getNonPerishableProducts();
		return new ResponseEntity<List<Products>>(product, HttpStatus.OK);
	}
	
}
