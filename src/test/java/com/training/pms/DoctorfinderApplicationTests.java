package com.training.pms;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DoctorfinderApplicationTests {

	@LocalServerPort
	private String port;
	
	private String baseURL = "http://localhost";
	
	@Autowired
	RestTemplate restTemplate;
	
	URL url;
	@BeforeEach
	public void setup() throws MalformedURLException {
		//http://localhost:5050/product
		url = new URL(baseURL+":"+port+"/product");
	}
	
	@Test
	void contextLoads() {
	}

}
