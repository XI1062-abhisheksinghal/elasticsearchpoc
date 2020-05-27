package com.home.elasticsearch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.elasticsearch.services.AirLineData;
import com.home.elasticsearch.services.EmployeeData;
import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/elasticsearch")
public class SearchData {
	
	@Autowired 
	private AirLineData airlineData;
	
	@Autowired
	private Tracer tracer;

	
	@Autowired
	private EmployeeData employeeData;
	
	private Map<String,Object> data = new HashMap<String,Object>();
	private List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
	
	
	@RequestMapping("/getAirlineData")
	public List<Map<String, Object>> getAirlineData(){
		
		
		Span span = tracer.buildSpan("Get Airline data").start();
		
		SearchResponse searchresponse=airlineData.getAirlineData();
		
        span.setTag("http.status_code", 200);
        
		SearchHit[] results = searchresponse.getHits().getHits();
		
		for(SearchHit hit:results) {
			
			data=hit.getSourceAsMap();
			dataList.add(data);
		}
		
		span.finish();
		return dataList;
	}
	
	
	@RequestMapping("getAllEmployee")
	public String getEmployeeData() {
		
		
		SearchResponse employeeResponse = employeeData.getEmployeeData();
		
		return employeeResponse.toString();
	}
	
	
	

}
