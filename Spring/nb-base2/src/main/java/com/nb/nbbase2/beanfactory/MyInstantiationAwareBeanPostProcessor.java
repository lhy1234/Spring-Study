package com.nb.nbbase2.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * create by lihaoyang on 2020/9/13
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    //接口方法：在实例化Bean前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        //只处理容器中的car
        if ("car".equals(beanName)) {
            System.err.println("调用了InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }

        return null;
    }

    //接口方法：在实例化Bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        //只处理容器中的car
        if ("car".equals(beanName)) {
            System.err.println("调用了InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }

        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        //只处理容器中的car
        if ("car".equals(beanName)) {
            System.err.println("调用了InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
