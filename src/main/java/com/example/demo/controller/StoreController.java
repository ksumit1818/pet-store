package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.store.model.RequestStoreObject;

@RestController
public class StoreController {
	
	@GetMapping("/store/inventory")
	public ResponseEntity<String> getStore() {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/inventory";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		response.getBody();
		return response;
	}
	
	@PostMapping("/store/order")
	public RequestStoreObject postOrder() {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/order";
		RequestStoreObject req= new RequestStoreObject();
		RestTemplate template = new RestTemplate();
		HttpEntity<Object> entity=null;
		HttpHeaders header= new HttpHeaders();
		header.add("accept", "application/json");
		header.add("Content-Type", "application/json");
		entity = new HttpEntity<Object>(req,header);
		ResponseEntity<RequestStoreObject> response = template.postForEntity(url,entity, RequestStoreObject.class);
		return response.getBody();
	}
	
	@GetMapping("/store/order/{orderId}")
	public ResponseEntity<String> getOrderById(@PathVariable int orderId) {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/order/";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url + orderId, String.class);
		response.getBody();
		return response;
	}
	
	@DeleteMapping("/store/order/{orderId}")
	public ResponseEntity<String> deleteOrderById(@PathVariable int orderId) {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/order/";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url + orderId, String.class);
		response.getBody();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
