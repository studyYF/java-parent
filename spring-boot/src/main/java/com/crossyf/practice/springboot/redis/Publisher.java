package com.crossyf.practice.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Created by crossyf.
 * @date 2020/2/17
 * 功能:
 */
@Service
public class Publisher {

    @Autowired
    private RedisTemplate redisTemplate;

    public void publish(Object msg) {
        redisTemplate.convertAndSend("redis-demo-channel",msg);
    }
}
