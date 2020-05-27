package com.home.elasticsearch.services;

import java.util.Arrays;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AirLineData {
	
	@Autowired 
	private Client client;
	
	
	
	public SearchResponse getAirlineData() {
		
		
		//FlighNum :- 4YI4O8X,R4DJ22Q
		
		TermQueryBuilder query = QueryBuilders.termQuery("FlightNum", "HO1NEOX");
		
		TermsQueryBuilder queries = QueryBuilders.termsQuery("FlightNum", Arrays.asList("4YI4O8X","R4DJ22Q"));
		
		final BoolQueryBuilder querybool= QueryBuilders
			    .boolQuery()
			    .should(QueryBuilders.termQuery("OriginWeather","Rain"))
			    .must(QueryBuilders.termQuery("FlightDelay","true"))
			    .must(QueryBuilders.termQuery("FlightDelayType","No Delay"));
		
		
		
	final SearchResponse response = client
		    .prepareSearch()
		    .setIndices("kibana_sample_data_flights")
		   .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
		    //.setQuery(QueryBuilders.matchAllQuery())
		    .setQuery(query)
		    .setQuery(queries)
		    //.setQuery(querybool)
		    .execute()
		    .actionGet();
	
		    //.setFrom(0)
		    //.setSize(10)
		   // .setTimeout(TimeValue.timeValueMillis(100))
		    

	
	
	    return response;
	
	}

}
