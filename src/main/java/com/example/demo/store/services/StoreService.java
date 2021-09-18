package com.example.demo.store.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.store.model.RequestStoreObject;

public interface StoreService {

	ResponseEntity<String> getStore();

	RequestStoreObject postOrder(RequestStoreObject request);

	ResponseEntity<String> getOrderById(int orderId);

	ResponseEntity<HttpStatus> deleteOrderById(int orderId);

}
