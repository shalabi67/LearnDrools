package com.learn.drool.controllers;

import com.learn.drool.data.Product;
import com.learn.drool.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired ProductService productService;

	@RequestMapping(value = "/products/{productId}")
	public Product getProduct(@PathVariable(name="productId") int productId) {
		return productService.getProduct(productId);
	}

}
