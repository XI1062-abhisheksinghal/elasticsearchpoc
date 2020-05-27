package com.home.elasticsearch.services;

import java.io.IOException;
import java.util.Date;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateIndex {

	// Creating an Index in elasticSearch using XContentBuilder of elasticSearch
	// Library
	// Index can be created in elasticsearch using Map<String , Object>
	@Autowired
	private Client client;

	public IndexResponse createIndex() {
		IndexResponse response = null;

		try {

			response = client.prepareIndex("employee", "_doc")
					.setSource(XContentFactory.jsonBuilder().startObject()
							.field("user", "Abhishek")
							.field("postDate", new Date())
							.field("message", "trying hands on Elasticsearch")
							.field("job", "Developer")
						    .field("phone", "89898998989")
						    .endObject())
					.get();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

}
