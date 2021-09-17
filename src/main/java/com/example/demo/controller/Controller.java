package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	@GetMapping("/pet/{petId}")
	public ResponseEntity<String> getResp(@PathVariable Long petId) {
		String url="https://virtserver.swaggerhub.com/asd312/temp/1.0.0/pet/1";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response= template.getForEntity(url, String.class);
		return response;
	}
	
	@GetMapping("/hello")
	public String gethello() {
		return "Hello";
	}

}

