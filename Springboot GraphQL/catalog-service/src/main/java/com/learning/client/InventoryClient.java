package com.learning.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import com.learning.dto.Item;
import com.learning.dto.ItemRequestDTO;

@Component
public class InventoryClient {

	@Autowired
	private HttpGraphQlClient graphQLClient;
	
	public List<Item> viewProducts(){
		String graphQLQuery="query GetProducts {\r\n"
				+ "    getProducts {\r\n"
				+ "        name\r\n"
				+ "        price\r\n"
				+ "    }\r\n"
				+ "}";
		return graphQLClient.document(graphQLQuery)
		.retrieve("getProducts")
		.toEntityList(Item.class).block();
	}
	
	public List<Item> viewProductsByCategory(String category){
		String graphQlQuery = String.format("query GetProductByCategory {\r\n"
				+ "    getProductByCategory(category: \"%s\") {\r\n"
				+ "        name\r\n"
				+ "        category\r\n"
				+ "        price\r\n"
				+ "        stock\r\n"
				+ "    }\r\n"
				+ "}",category);
		return graphQLClient.document(graphQlQuery)
				.retrieve("getProductByCategory")
				.toEntityList(Item.class).block();
	}
	
	public Item receiveNewShipment(ItemRequestDTO itemRequest) {
		String graphQlQuery = String.format("mutation ReceiveNewShipment {\r\n"
				+ "    receiveNewShipment(id: \"%s\", quantity: %d) {\r\n"
				+ "        name\r\n"
				+ "        price\r\n"
				+ "        stock\r\n"
				+ "    }\r\n"
				+ "}",itemRequest.getId(),itemRequest.getQuantity());
		return graphQLClient.document(graphQlQuery)
		.retrieve("receiveNewShipment")
		.toEntity(Item.class).block();
	}
}
