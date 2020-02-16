package com.crossyf.practice.springboot.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Created by YangFan.
 * @date 2020/2/14
 * 功能:
 */
public interface EsTestService extends ElasticsearchRepository<User,String> {

}
