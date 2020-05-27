package com.home.elasticsearch.configuration;



import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.ClusterName;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * Configuration file to connect to elasticSearch
 */
@SuppressWarnings({ "deprecation", "unused" })
@Configuration
public class ElasticsearchClientConfiguration {
    @SuppressWarnings({ "resource", "deprecation" })
	@Bean(destroyMethod = "close")
    TransportClient transportClient() throws UnknownHostException  {
        return new PreBuiltTransportClient(
            Settings.builder().put(ClusterName.CLUSTER_NAME_SETTING.getKey(), "docker-cluster")
                .build()
            )
            .addTransportAddress(new TransportAddress(
                InetAddress.getByName("localhost"), 9300));
    }
}