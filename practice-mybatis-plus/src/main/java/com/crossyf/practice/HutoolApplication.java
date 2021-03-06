package com.crossyf.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Created by YangFan.
 * @date 2019/11/11
 * 功能:
 */
@SpringBootApplication(scanBasePackages = {"com.crossyf.practice"})
@MapperScan(basePackages = "com.crossyf.practice")
public class HutoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HutoolApplication.class,args);
    }
}

/*
BeanFactoryPostProcessor 处理bean的定义


BeanPostProcessor 处理bean完成实例化后的对象

 */