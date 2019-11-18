package com.crossyf.practice.springboot;

import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author Created by YangFan.
 * @date 2019/11/13
 * 功能:
 */
public class SpringFactoriesLoaderStudy {

    /*
    jvm 的类加载器有三个，BootstrapClassLoader加载java核心包中的类，ExtClassLoader加载扩展类库
    AppClassLoader加载应用的类路径下的类库（classpath）


    使用双亲委派模型加载类

    spring中的类加载器 SpringFactoriesLoader




     */

    /**
     * 类加载器的findResource方法会遍历其负责加载的所有jar包，找到jar包名称为name的资源文件，包括class文件
     * 下面的例子就是查找Array.class文件
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String name = "java/sql/Array.class";
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(name);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url.toString());
        }
    }

    /*
    Spring中的类加载器是SpringFactoryLoader
    原理是，加载所有的META-INF/spring.factories的配置文件，找到key为factoryClass的属性，获取他的值value，
    利用反射机制加载类

    通过这样的机制，我们可以十分的方便的为框架提供各式各样的扩展插件，我们可以自己定义自己的组件的自动装配配置类，
    然后通过工厂加载机制让 Spring 进行加载并得到自动装配。

     */


}
