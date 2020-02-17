package com.crossyf.practice.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;

/**
 * @author Created by crossyf.
 * @date 2020/2/17
 * 功能:
 */

@Component
public class RedisConfig {


    @Autowired
    private RedisListener redisListener;


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        RedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(serializer);
        return redisTemplate;
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(redisListener, new PatternTopic("redis-demo-channel"));
        return container;
    }

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory factory) {
        return new RedisLockRegistry(factory,"demo-lock",60);
    }


}
