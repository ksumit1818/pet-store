package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.store.model.RequestStoreObject;
import com.example.demo.store.services.StoreService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping("/store/inventory")
	public ResponseEntity<String> getStore() {
		return service.getStore();
	}

	@PostMapping("/store/order")
	public RequestStoreObject postOrder(@RequestBody RequestStoreObject request) {
		return service.postOrder(request);
	}

	@GetMapping("/store/order/{orderId}")
	public ResponseEntity<String> getOrderById(@PathVariable int orderId) {
		return service.getOrderById(orderId);
	}

//	@DeleteMapping("/store/order/{orderId}")
//	public ResponseEntity<HttpStatus> deleteOrderById(@PathVariable int orderId) {
//		return service.deleteOrderById(orderId);
//	}

}
