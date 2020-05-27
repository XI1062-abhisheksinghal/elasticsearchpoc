package com.home.elasticsearch.services;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClusterInfo {
	
	@SuppressWarnings("deprecation")
	@Autowired 
	private TransportClient client;

	
	public ClusterHealthResponse getClusterHealth() {
	
	final ClusterHealthResponse response = client
		    .admin()
		    .cluster()
		    .prepareHealth()
		    .setWaitForGreenStatus()
		    .setTimeout(TimeValue.timeValueSeconds(5))
		    .execute()
		    .actionGet();
	
	return response;
   
	}
}
