package com.nb.nbbase2.beanfactory;

import com.nb.nbbase2.beans.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * create by lihaoyang on 2020/9/14
 */
public class BeanLifeCycle {

    private static void LifeCycleInBeanFactory(){

        //1,装载Spring配置文件并启动
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)factory);
        reader.loadBeanDefinitions(res);

        //2,向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory)factory).addBeanPostProcessor(new MyBeanPostProcessor());

        //3,向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
     //   ((ConfigurableBeanFactory)factory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //4,第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用
        Car car1 = factory.getBean("car",Car.class);

        //5，第二次从容器中获取car，直接从缓存池中获取
        Car car2 = factory.getBean("car",Car.class);

        //6,判断是否是一个
        System.err.println("car1 == car2 :" +(car1==car2));

        //关闭容器
        ((DefaultListableBeanFactory)factory).destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}