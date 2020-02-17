package com.crossyf.practice.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Created by crossyf.
 * @date 2020/2/17
 * 功能:
 */

@RestController
public class RedisController {

    @Autowired
    private Publisher publisher;


    @GetMapping(value = "publish")
    public void testPublish(String message) {
        publisher.publish(message);
    }

}
