package com.learning;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.entity.Product;
import com.learning.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class InventoryServiceApplication {
	
//	@Autowired
//	private ProductRepository repository;
//	
//	@PostConstruct
//	public void initDB() {
//		List<Product> products = Stream.of(
//				new Product("Laptop", "Electronics", 74999.99f, 50),
//				new Product("Office chair", "Furniture", 999.99f, 200)
//				).collect(Collectors.toList());
//		
//		repository.saveAll(products);
//				
//	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

}
