package com.nb.nbbase2;


import com.nb.nbbase2.beans.Car;
import com.nb.nbbase2.beans.User;
import com.nb.nbbase2.config.BeansConfig;
import com.nb.nbbase2.listener.ExtConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.lang.Nullable;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * create by lihaoyang on 2020/9/8
 */
public class SpringTest {



    @Test
    public void testCTX() {
       // ApplicationContext ctx = new FileSystemXmlApplicationContext("file:D:\\Z_lhy\\beans.xml");

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Car car = ctx.getBean("car",Car.class);
        System.err.println(car.toString());
    }


    @Test
    public void testJavaConfig() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfig.class);
        Car car = ctx.getBean("car",Car.class);
        String[] names = ctx.getBeanDefinitionNames();
        for(String name : names){
            System.err.println("name --- "+name);
        }
        System.err.println(car.toString());
    }



    @Test
    public void testWeb() {


        //WebApplicationContextUtils.getWebApplicationContext()

    }








    @Test
    public void testEv() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ExtConfig.class);
        //发布事件；
        ctx.publishEvent(new ApplicationEvent("我发布的事件") {
        });
        ctx.close();
    }

    @Test
    public void test() {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("beans.xml");
        System.err.println("UrL--"+resolver);
        //被废弃
        //BeanFactory factory = new XmlBeanFactory(resource);

        /**
         * XmlBeanDefinitionReader通过Resource装载Spring配置文件并启动IoC容器，
         * 然后就可以通过BeanFactory#getBean(beanName)从容器获取Bean
         */
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);



        System.err.println("----> "+factory.getBean("car"));


    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Object carBean = ctx.getBean("&carBean");
        System.err.println(carBean.getClass().toString());
    }

    @Test
    public void testArgs(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        User user = ctx.getBean(User.class,new Object[]{"niubei",18});
        System.err.println("user = " + user);
    }
}



