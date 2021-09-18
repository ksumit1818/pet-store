package com.example.demo.store.servicesImpl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.store.model.RequestStoreObject;
import com.example.demo.store.services.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

	@Override
	public ResponseEntity<String> getStore() {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/inventory";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		response.getBody();
		return response;
	}

	@Override
	public RequestStoreObject postOrder(RequestStoreObject request) {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/order";
		RestTemplate template = new RestTemplate();
		HttpEntity<Object> entity=null;
		HttpHeaders header= new HttpHeaders();
		header.add("accept", "application/json");
		header.add("Content-Type", "application/json");
		entity = new HttpEntity<Object>(request,header);
		ResponseEntity<RequestStoreObject> response = template.postForEntity(url,entity, RequestStoreObject.class);
		return response.getBody();
	}

	@Override
	public ResponseEntity<String> getOrderById(int orderId) {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/order/";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url + orderId, String.class);
		response.getBody();
		return response;
	}

	@Override
	public ResponseEntity<HttpStatus> deleteOrderById(int orderId) {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/store/order/";
		RestTemplate template = new RestTemplate();
		template.delete(url+orderId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
