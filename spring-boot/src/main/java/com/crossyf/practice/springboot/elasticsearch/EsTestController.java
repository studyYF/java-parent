package com.crossyf.practice.springboot.elasticsearch;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by YangFan.
 * @date 2020/2/14
 * 功能:
 */
@RestController
@RequestMapping("/test")
public class EsTestController {

    @Autowired
    private EsTestService esTestService;

    @GetMapping(value = "list")
    public Object getUserList() {
        Iterable<User> all = esTestService.findAll();
        List<User> userList = new ArrayList<>();
        all.forEach(userList::add);
        return userList;
    }


    @GetMapping(value = "query")
    public Object getUserByParam(String keyword) {
        List<User> list = new ArrayList<>();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.should(QueryBuilders.matchPhraseQuery("name",keyword));
        queryBuilder.should(QueryBuilders.matchPhraseQuery("account",keyword));
        System.out.println(queryBuilder.toString());
        Iterable<User> search =
                esTestService.search(queryBuilder);
        search.forEach(list::add);
        return list;
    }

}
