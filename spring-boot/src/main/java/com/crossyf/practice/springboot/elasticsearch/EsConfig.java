package com.crossyf.practice.springboot.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Created by crossyf.
 * @date 2020/2/19
 * 功能: Elasticsearch 配置TransportClient
 */
@Configuration
public class EsConfig {

    @Value("${spring.elasticsearch.port}")
    private String port;

    @Value("${spring.elasticsearch.host}")
    private String host;


    @Bean
    public RestHighLevelClient restHighLevelClient() {
        HttpHost httpHost = new HttpHost(host, Integer.parseInt(port));
        RestClientBuilder builder = RestClient.builder(httpHost);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }



}
