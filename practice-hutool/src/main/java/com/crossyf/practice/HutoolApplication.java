package com.crossyf.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Created by YangFan.
 * @date 2019/11/11
 * 功能:
 */
@SpringBootApplication(scanBasePackages = {"com.crossyf.practice"})
public class HutoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(HutoolApplication.class,args);
    }
}
