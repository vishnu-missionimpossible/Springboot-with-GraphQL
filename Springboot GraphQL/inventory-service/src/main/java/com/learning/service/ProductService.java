package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Product;
import com.learning.repository.ProductRepository;

@Service
public class ProductService {
	
    @Autowired
	private ProductRepository repository;
    
    public List<Product> getProducts(){
    	return repository.findAll();
    	}
    
    public List<Product> getProductsByCategory(String category){
    	return repository.findByCategory(category);
    }
    
    //sales team wants to update the stock of a product in (IS)
    public Product updateStock(int id, int quantity) {
    	Product existingproduct = repository.findById(id)
    			.orElseThrow(
    					()->new RuntimeException("Product not found with id "+id));
    	existingproduct.setStock(quantity);
    	return repository.save(existingproduct);
    }
    
    //warehouse : receive new Shipment
    public Product receiveNewShipment(int id, int quantity) {
    	Product existingproduct = repository.findById(id)
    			.orElseThrow(
    					()->new RuntimeException("Product not found with id "+id));
    	existingproduct.setStock(existingproduct.getStock()+quantity);
    	return repository.save(existingproduct);
    	}
    
    
}
