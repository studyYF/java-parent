package com.crossyf.practice.springboot;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.web.servlet.context.WebApplicationContextServletContextAwareProcessor;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Created by YangFan.
 * @date 2019/11/12
 * 功能:
 */
public class SpringIOC {

    /*
    BeanDefinition：容器中每个bean都会对应一个BeanDefinition，负责保存对象的所有信息，包括对象的class，是否是
    抽象类，构造方法以及其他的属性

    BeanDefinitionRegistry：bean的注册逻辑，

    BeanFactory： bean的管理逻辑

    上面两个类的实现类就承担了bean的注册和管理，比如DefaultListableBeanFactory



     */


    HttpServletRequest request = null;
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    AbstractBeanDefinition definition = new RootBeanDefinition(Business.class);

    //注册bean
//    beanFactory.registerBeanDefinition("beanName",definition);


    //获取bean
    BeanFactory beanFactor1 = (BeanFactory)beanFactory;
    Business business = (Business) beanFactor1.getBean("beanName");


    /*
        容器启动阶段
        利用BeanDefinitionReader，把ConfigurationMetaData的数据进行加载和解析，组成
        BeanDefinition，然后在用BeanDefinition组装成相应的BeanDefinitionRegister,
        完成bean的组装


        bean的实例化阶段

        使用BeanFactory对管理bean的时候，默认会在需要调用bean的时候，判断bean是否已经初始化，如果没有初始化，
        则根据BeanDefinitionRegister中的信息，初始化一个实例，并且返回。

        通常情况，我们使用ApplicationContext对bean进行管理，他是BeanFactory更高级的容器，ApplicationContext
        默认会在容器初始化的时候完成所有的bean的注册以及依赖注入的操作

     */



    /*

        Spring容器的扩展机制

        bean在生命周期的不同阶段，提供了不同的扩展来改变bean的命运。在容器的启动阶段，可以使用
        BeanFactoryPostProcessor允许在实例化相应的对象之前修改bean的属性或者增加其他信息
        典型的例子就是加载xml配置文件的时候，会把一些相关的配置单独用property文件保存，使用的时候用占位符表示，
        当容器初始化创建实例的时候，使用PropertyPlaceholderConfigurer作为BeanFactoryPostProcessor，
        去相关配置文件中加载相应的值，并替换占位符


        BeanPostProcessor 存在与对象实例化阶段，BeanFactoryPostProcessor处理bean定义，BeanPostProcessor处理的是
        bean完成实例化后的对象。
        比如spring中有很多的aware接口，其作用就是在bean实例化以后将aware定义的依赖注入到bean中去，以常见的
        ApplicationContextAware为例
        当我们实现ApplicationContextAware接口时，bean在初始化到走到BeanPostProcessor过程的时候，容器会检测到之前注入
        到容器中的ApplicationContextAwareProcessor，然后调用postProcessBeforeInitialization()方法，设置当前bean
        的相关依赖。


     */

//    BeanPostProcessor
//    WebApplicationContextServletContextAwareProcessor




}
