package com.capg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capg.dto.ProductDto;
import com.capg.entity.Product;
import com.capg.service.IProductService;

@Controller
public class HelloController {
	
	 private static Logger Log= LoggerFactory.getLogger(HelloController.class);

	    @Autowired
	    private IProductService productService;
	    
	 @GetMapping("/add")
	 public ModelAndView addProduct() {
		 return new ModelAndView("addProductt");
	 }
	 @GetMapping("/processaddproduct")
	 public ModelAndView registerProduct(@RequestParam("productId")int productId,@RequestParam("productName")String productName,
			 @RequestParam("productPrice")int productPrice) {
		 Product product=new Product(productId,productName,productPrice);
		 Product prod=productService.addProduct(product);
		 return new ModelAndView("addedProduct");
		 
	 }
	 @GetMapping("/allProduct")
	 public ModelAndView allProductDetail() {
		 List<Product> product=productService.retrieveAllProduct();
		 return new ModelAndView("allProductList");
	 }

}
