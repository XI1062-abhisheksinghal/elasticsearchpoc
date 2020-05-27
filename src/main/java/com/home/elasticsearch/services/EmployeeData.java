package com.home.elasticsearch.services;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeData {
	
	
	@Autowired 
	private Client client;
	
	public SearchResponse getEmployeeData() {
	
		TermQueryBuilder query = QueryBuilders.termQuery("job", "Developer");
		
		final SearchResponse response = client
			    .prepareSearch()
			    .setIndices("employee")
			    .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
			    .setQuery(query)
			    //.setQuery(QueryBuilders.matchAllQuery())
			    .execute()
			    .actionGet();
			    
		return response;
		
	}
}
