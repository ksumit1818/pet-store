package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Pet;
import com.example.demo.services.PetService;

@RestController
public class PetController {
	
	@Autowired
	private PetService service;

	@GetMapping("/pet/{petId}")
	public Pet getPetResp(@PathVariable Long petId) {
		return service.getPetById(petId);
	}
	
}
