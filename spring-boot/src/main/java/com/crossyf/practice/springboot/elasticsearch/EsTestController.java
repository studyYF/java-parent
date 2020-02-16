package com.crossyf.practice.springboot.elasticsearch;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有列表
     * @return 结果
     */
    @GetMapping(value = "list")
    public Object getUserList() {
        Iterable<User> all = esTestService.findAll();
        List<User> userList = new ArrayList<>();
        all.forEach(userList::add);
        return userList;
    }


    /**
     * 条件查询
     * @param keyword 关键字
     * @return 结果
     */
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

    /**
     * 分页查询数据
     * @param page 页数
     * @param size 每页条树
     * @return 分页数据
     */
    @GetMapping(value = "pageList")
    public Object getListByPage(@RequestParam(value = "page",defaultValue = "1") String page,
                                @RequestParam(value = "size",defaultValue = "10") String size) {
        int pageNum = Integer.parseInt(page);
        int pageSize = Integer.parseInt(size);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchPhraseQuery("password","b53cac62e7175637d4beb3b16b2f7915"));
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "id");
        Page<User> search = esTestService.search(queryBuilder, pageable);
        System.out.println(search);
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("data",search.getContent());
        resultMap.put("total",search.getTotalElements());
        resultMap.put("pages",search.getTotalPages());
        return resultMap;
    }


}
