package com.crossyf.practice.springboot.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Created by YangFan.
 * @date 2020/2/14
 * 功能:
 */
@Data
@Document(type = "_doc", indexName = "user",createIndex = false, useServerConfiguration = true)
public class User {

    @Id
    private String id;
    private String avatar;
    @Field(type = FieldType.Text,fielddata = true)
    private String name;
    private String password;
    @Field(type = FieldType.Text)
    private String account;
}
