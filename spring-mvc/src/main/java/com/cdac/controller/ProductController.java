package com.cdac.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.entity.Product;
import com.cdac.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepo;
	
	@RequestMapping("/all-products")
	public String all(Map model) {
		List<Product> list = productRepo.findAll();
		model.put("productsData", list);
		return "viewProducts.jsp";
	}
	
	//Spring can automatically read the incoming data
	//and store it in an object for us
	@RequestMapping("/add-product")
	public String add(Product product, Map model) {
		productRepo.save(product);
		model.put("message", "Product added successfully!");
		return "addProduct.jsp";
	}
}
