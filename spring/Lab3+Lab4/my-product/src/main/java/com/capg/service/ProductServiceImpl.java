package com.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IProductDao;
import com.capg.entity.Product;
@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	
	public IProductDao dao;

	public IProductDao getDao() {
		return dao;
	}
	@Autowired
	public void setDao(IProductDao dao) {
		this.dao = dao;
	}

	@Override
	public Product addProduct(Product product) {
		return dao.addProduct(product);
	}

	@Override
	public List<Product> retrieveAllProduct() {
		return dao.retrieveAllProduct();
	}

}
