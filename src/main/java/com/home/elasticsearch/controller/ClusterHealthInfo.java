package com.home.elasticsearch.controller;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.elasticsearch.services.ClusterInfo;

@RestController
@RequestMapping("/elasticsearch")
public class ClusterHealthInfo {
	
	@Autowired 
	private ClusterInfo clusterInfo;
	
	
	@RequestMapping("clusterhealth")
	public ClusterHealthResponse getClusterHealth() {
		
		ClusterHealthResponse health = clusterInfo.getClusterHealth();
		
		return health;
	}

}
