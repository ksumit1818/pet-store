package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Spy
	URI uri;

	@Value("${temp.url}")
	URI url3;
	
	@Test
	public void Mocktest() throws IOException, URISyntaxException {
		
		String req = "hello";
		String resp = "{\r\n" + "    \"headers\": {\r\n" + "        \"host\": \"mocktarget.apigee.net\",\r\n"
				+ "        \"content-length\": \"7\",\r\n"
				+ "        \"sec-ch-ua\": \"\\\"Chromium\\\";v=\\\"94\\\", \\\"Google Chrome\\\";v=\\\"94\\\", \\\";Not A Brand\\\";v=\\\"99\\\"\",\r\n"
				+ "        \"cache-control\": \"no-cache\",\r\n" + "        \"content-type\": \"application/json\",\r\n"
				+ "        \"sec-ch-ua-mobile\": \"?0\",\r\n"
				+ "        \"user-agent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36\",\r\n"
				+ "        \"sec-ch-ua-platform\": \"\\\"Windows\\\"\",\r\n"
				+ "        \"postman-token\": \"4d4416d0-1c38-cc72-1518-b1f79f4a05f2\",\r\n"
				+ "        \"accept\": \"*/*\",\r\n"
				+ "        \"origin\": \"chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop\",\r\n"
				+ "        \"sec-fetch-site\": \"none\",\r\n" + "        \"sec-fetch-mode\": \"cors\",\r\n"
				+ "        \"sec-fetch-dest\": \"empty\",\r\n"
				+ "        \"accept-encoding\": \"gzip, deflate, br\",\r\n"
				+ "        \"accept-language\": \"en-US,en;q=0.9\",\r\n"
				+ "        \"x-cloud-trace-context\": \"d692db5f3fc167e8a1e98fd8cbcc951c/11489623917367931595\",\r\n"
				+ "        \"x-client-data\": \"CgSM6ZsV\",\r\n" + "        \"via\": \"1.1 google\",\r\n"
				+ "        \"x-forwarded-for\": \"203.192.244.59, 35.227.194.212\",\r\n"
				+ "        \"x-forwarded-proto\": \"https\",\r\n" + "        \"connection\": \"Keep-Alive\"\r\n"
				+ "    },\r\n" + "    \"method\": \"POST\",\r\n" + "    \"url\": \"/\",\r\n"
				+ "    \"body\": \"\\\"hello\\\"\"\r\n" + "}";
		ResponseEntity<String> res2 = new ResponseEntity<>(resp, HttpStatus.OK);

		String uri = url3.toString();

		Mockito.when(restTemplate.postForEntity(ArgumentMatchers.eq(uri), Mockito.any(), ArgumentMatchers.eq(String.class)))
				.thenReturn(res2);
		service.getMock(req);
	}

	
	
	
	
	
	
	
//    @Test
//    public void test() throws Exception {
//    	long s=1L;
//    	String res="{\r\n"
//    			+ "    \"id\": 0,\r\n"
//    			+ "    \"category\": {\r\n"
//    			+ "        \"id\": 0,\r\n"
//    			+ "        \"name\": \"string\"\r\n"
//    			+ "    },\r\n"
//    			+ "    \"name\": \"doggie\",\r\n"
//    			+ "    \"photoUrls\": [\r\n"
//    			+ "        \"string\"\r\n"
//    			+ "    ],\r\n"
//    			+ "    \"tags\": [\r\n"
//    			+ "        {\r\n"
//    			+ "            \"id\": 0,\r\n"
//    			+ "            \"name\": \"string\"\r\n"
//    			+ "        }\r\n"
//    			+ "    ],\r\n"
//    			+ "    \"status\": \"available\"\r\n"
//    			+ "}";
//    	
//        ResponseEntity<Object> res2 = new ResponseEntity<>(res,HttpStatus.OK);
//		Mockito.when(restTemplate.getForEntity(Mockito.anyString(), ArgumentMatchers.any()))
//                .thenReturn(res2);
//        service.getPetById(s);
//    }

}
