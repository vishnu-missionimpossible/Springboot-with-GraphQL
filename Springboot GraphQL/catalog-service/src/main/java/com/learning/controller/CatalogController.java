package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.Item;
import com.learning.dto.ItemRequestDTO;
import com.learning.service.CatalogService;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private CatalogService catalogService;
	
	@GetMapping("/products")
	public List<Item> viewProducts(){
		return catalogService.viewProducts();
	}
	
	@GetMapping("/products/category")
	public List<Item> viewProductsByCategory(@RequestParam("category") String category){
		return catalogService.viewProductsByCategory(category);
	}
	
	@PostMapping("/shipment")
	public Item receiveNewShipment(@RequestBody ItemRequestDTO itemRequest) {
		return catalogService.receiveNewShipment(itemRequest);
	}
}
