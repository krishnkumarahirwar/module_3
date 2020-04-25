package com.capg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.ProductDto;
import com.capg.entity.Product;
import com.capg.service.IProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	private IProductService service;
	
	 @PostMapping("/customer/add")
	    public ResponseEntity<Product> addCustomer(@RequestBody ProductDto dto) {
	        Product product = convert(dto);
	        product = service.addProduct(product);
	        ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
	        return response;
	    }

	    Product convert(ProductDto dto) {
	        Product product = new Product();
	        product.setProductId(dto.getProductId());
	        product.setProductName(dto.getProductName());
	        product.setProductPrice(dto.getProductPrice());
	        return product;
	    }


	    @GetMapping("/customers")
	    public ResponseEntity<List<Product>> fetchAll() {
	        List<Product> products = service.retrieveAllProduct();
	        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
	        return response;
	    }
	    @ExceptionHandler(Throwable.class)
	    public ResponseEntity<String> handleAllExceptions(Throwable exception){
	    	Logger Log = null;
			Log.error("handleallexception",exception);
	    	ResponseEntity<String> response =new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	    	return response;
	    }

}
