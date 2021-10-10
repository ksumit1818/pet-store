package com.example.demo.servicesImpl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Pet;
import com.example.demo.services.PetService;

@Service
public class PetServiceImpl implements PetService {

	RestTemplate template;
	
	@Value("${remo.url}")
	String url; 
	
	@Value("${temp.url}")
	String uri;
	
	@Override
	public String getMock(String s) {
		template = new RestTemplate();
		ResponseEntity<String> response=null;
//		String urlT="https://mocktarget.apigee.net/echo";
		String urlT = new String(uri);

		
		response = template.postForEntity(urlT,s, String.class);
//		response = template.postForEntity("https://mocktarget.apigee.net/echo",s, String.class);
		return response.getBody();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Pet getPetById(Long petId) {
		template=new RestTemplate();
		ResponseEntity<Pet> response=null;
		
//		ResponseEntity<Pet> response = template.getForEntity(url+ petId, Pet.class);
//		response = template.getForEntity(url, Pet.class);
		response = template.getForEntity("https://virtserver.swaggerhub.com/asd312/temp/1.0.0/pet/1", Pet.class);
		return response.getBody();
	}
	

}
