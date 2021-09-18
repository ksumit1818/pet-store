package com.example.demo.servicesImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Pet;
import com.example.demo.services.PetService;

@Service
public class PetServiceImpl implements PetService {

	@Override
	public Pet getPetById(Long petId) {
		String url = "https://virtserver.swaggerhub.com/asd312/temp/1.0.0/pet/";
		RestTemplate template = new RestTemplate();
		ResponseEntity<Pet> response = template.getForEntity(url+ petId, Pet.class);
		return response.getBody();
	}

}
