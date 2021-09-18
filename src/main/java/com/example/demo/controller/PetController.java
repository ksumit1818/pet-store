package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Pet;

@RestController
public class PetController {

	@GetMapping("/pet/{petId}")
	public Pet getPetResp(@PathVariable Long petId) {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/pet/1";
		RestTemplate template = new RestTemplate();
		ResponseEntity<Pet> response = template.getForEntity(url, Pet.class);
		return response.getBody();
	}
	
}
