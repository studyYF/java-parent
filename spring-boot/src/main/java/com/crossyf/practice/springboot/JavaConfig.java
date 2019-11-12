package com.crossyf.practice.springboot;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Created by YangFan.
 * @date 2019/11/12
 * 功能:
 */
public class JavaConfig {


    /*
    @ComponentScan()
    spring会自动扫描所有通过注解配置的bean，然后将其注册到ioc容器中，其中有basePackages等属性指定扫描的范围，
    如果不指定返范围，默认从声明@ComponentScan所在的类package进行扫描，因此SpringBoot的启动类都默认在
    src/main/java目录下面，这样就会扫描整个目录


    @Import
    @Import注解用于导入配置类
    同时导入多个配置类，使用@Import({A.class,B.class})

    @Conditional
    @Conditional注解表示在满足某种条件后才初始化一个bean或者启用某些配置。一般用在@Component，@Service，@Configuration
    等注解上，或者由@Bean注解的方法上
    @Conditional(JdbcTemplateCondition.class)
    其中JdbcTemplateCondition实现了Conditional接口


    @ConfigurationProperties与@EnableConfigurationProperties

     */
    @Autowired
    private FtpConfig ftpConfig;




}
