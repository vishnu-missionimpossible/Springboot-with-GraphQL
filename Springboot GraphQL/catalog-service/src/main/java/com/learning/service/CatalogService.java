package com.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.client.InventoryClient;
import com.learning.dto.Item;
import com.learning.dto.ItemRequestDTO;

@Service
public class CatalogService {

	@Autowired
	private InventoryClient inventoryClient;
	
	public List<Item> viewProducts(){
		return inventoryClient.viewProducts();
	}
	
	public List<Item> viewProductsByCategory(String category){
		return inventoryClient.viewProductsByCategory(category);
	}
	
	public Item receiveNewShipment(ItemRequestDTO itemRequest) {
		return inventoryClient.receiveNewShipment(itemRequest);
	}
}
