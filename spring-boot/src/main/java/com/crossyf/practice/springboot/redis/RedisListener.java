package com.crossyf.practice.springboot.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;

/**
 * @author Created by crossyf.
 * @date 2020/2/17
 * 功能:
 */
@Slf4j
@Component
public class RedisListener implements MessageListener {

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        Lock lock = redisLockRegistry.obtain("lock");
        try {
            lock.lock();
            log.info("从消息通道= {}监听到消息",new String(bytes));
            log.info("从消息通道= {}监听到消息", new String(message.getChannel()));
            log.info("元消息={}",message.getBody());
            RedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
            log.info("反序列化后的消息={}",serializer.deserialize(message.getBody()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
