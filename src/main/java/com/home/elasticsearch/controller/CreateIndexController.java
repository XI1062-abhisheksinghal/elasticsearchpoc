package com.home.elasticsearch.controller;

import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.home.elasticsearch.model.Employee;
import com.home.elasticsearch.services.CreateIndex;

@RestController
@RequestMapping("/elasticsearch")
public class CreateIndexController {
	
	
	@Autowired
	private CreateIndex createIndex;
	
	@Autowired
	private RestTemplate restClient;
	
	
	@RequestMapping("createemployeeindex")
	public IndexResponse createEmployeeIndex() {
		
		IndexResponse response =createIndex.createIndex();
		System.out.println("====="+response);
		return response;
	}
	
	//Add the record to the employee index 
	@RequestMapping("addemployeedata")
	@PostMapping
	public String addEmployeeData(@RequestBody Employee emp) {
		
		
		ResponseEntity<String> res =restClient.postForEntity("http://localhost:9200/employee/_doc",emp,String.class);
		
	 return res.getBody();
		
	}

}
