package com.shop.server.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.server.model.Products;
import com.shop.server.persistence.AbstractDao;
import com.shop.server.persistence.ProductDetailDao;

@Repository(value = "ProductDetailDao")
@Transactional
public class ProductDetailsDaoImpl extends AbstractDao implements ProductDetailDao  {

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getAllProducts() {
		System.out.println("getAllProducts in ProductDetailsDaoImpl starts");
		Criteria c = getSession().createCriteria(Products.class);
		System.out.println((List<Products>) c.list());
		System.out.println("getAllProducts in ProductDetailsDaoImpl ends");
		return (List<Products>) c.list();
	}

	@Override
	public Products getProductById(int productid) {
		System.out.println("getProductsById in ProductDetailsDaoImpl starts");
		Criteria c = getSession().createCriteria(Products.class);
		c.add(Restrictions.eq("productid",productid));
		System.out.println((Products) c.list().get(0));
		System.out.println("getProductsById in ProductDetailsDaoImpl ends");
		return (Products) c.list().get(0);
	}

	@Override
	public Products getProductByName(String productName) {
		System.out.println("getProductsByName in ProductDetailsDaoImpl starts");
		Criteria c = getSession().createCriteria(Products.class);
		c.add(Restrictions.eq("productname",productName));
		System.out.println((Products) c.list().get(0));
		System.out.println("getProductsByName in ProductDetailsDaoImpl ends");
		return (Products) c.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getPerishableProducts() {
		System.out.println("getPerishableProducts in ProductDetailsDaoImpl starts");
		Criteria c = getSession().createCriteria(Products.class);
		c.add(Restrictions.eq("perishable","true"));
		//System.out.println((Products) c.list());
		System.out.println("getPerishableProducts in ProductDetailsDaoImpl ends");
		return (List<Products>) c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getNonPerishableProducts() {
		System.out.println("getNonPerishableProducts in ProductDetailsDaoImpl starts");
		Criteria c = getSession().createCriteria(Products.class);
		c.add(Restrictions.eq("perishable","false"));
		//System.out.println((Products) c.list());
		System.out.println("getNonPerishableProducts in ProductDetailsDaoImpl ends");
		return (List<Products>) c.list();
	}

}
