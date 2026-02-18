package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Product;
import com.learning.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@QueryMapping
	public List<Product> getProducts(){
		return service.getProducts();
	}
	
	@QueryMapping
	public List<Product> getProductByCategory(@Argument("category") String category){
		return service.getProductsByCategory(category);
	}
	
	@MutationMapping
	public Product updateStock(@Argument("id") int id,@Argument("stock") int stock) {
		
		return service.updateStock(id, stock);
	}
	
	@MutationMapping
	public Product receiveNewShipment(@Argument("id") int id,@Argument("quantity") int quantity) {
		
		return service.receiveNewShipment(id, quantity);
	}
	
	
}
