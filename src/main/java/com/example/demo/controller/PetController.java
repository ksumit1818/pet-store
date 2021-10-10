package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Pet;
import com.example.demo.services.PetService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PetController {
	
	@Autowired
	private PetService service;

	@GetMapping("/pet/{petId}")
	public Pet getPetResp(@PathVariable Long petId) {
		return service.getPetById(petId);
	}
	
	
	@PostMapping("/post/mock")
	public String getMock(@RequestBody String s) {
		return service.getMock(s);
	}
}
