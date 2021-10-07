package com.example.demo;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.servicesImpl.PetServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Mock
    RestTemplate restTemplate;
    @InjectMocks
    @Spy
    PetServiceImpl service;

    @Test
    public void test() throws Exception {
    	long s=1L;
    	String res="{\r\n"
    			+ "    \"id\": 0,\r\n"
    			+ "    \"category\": {\r\n"
    			+ "        \"id\": 0,\r\n"
    			+ "        \"name\": \"string\"\r\n"
    			+ "    },\r\n"
    			+ "    \"name\": \"doggie\",\r\n"
    			+ "    \"photoUrls\": [\r\n"
    			+ "        \"string\"\r\n"
    			+ "    ],\r\n"
    			+ "    \"tags\": [\r\n"
    			+ "        {\r\n"
    			+ "            \"id\": 0,\r\n"
    			+ "            \"name\": \"string\"\r\n"
    			+ "        }\r\n"
    			+ "    ],\r\n"
    			+ "    \"status\": \"available\"\r\n"
    			+ "}";
    	
        ResponseEntity<Object> res2 = new ResponseEntity<>(res,HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(), ArgumentMatchers.any()))
                .thenReturn(res2);
        service.getPetById(s);
    }

}
