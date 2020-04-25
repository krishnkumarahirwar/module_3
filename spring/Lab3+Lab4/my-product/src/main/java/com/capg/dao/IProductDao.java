package com.capg.dao;

import java.util.List;

import com.capg.entity.Product;

public interface IProductDao {
	
	public Product addProduct(Product product);
	public List<Product> retrieveAllProduct();

}
