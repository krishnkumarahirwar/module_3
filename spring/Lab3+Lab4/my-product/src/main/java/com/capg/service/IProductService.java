package com.capg.service;

import java.util.List;

import com.capg.entity.Product;

public interface IProductService {

	public Product addProduct(Product product);
	public List<Product> retrieveAllProduct();
}
