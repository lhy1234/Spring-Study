package com.nb.nbbase2.beanfactory;

import com.nb.nbbase2.beans.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * create by lihaoyang on 2020/9/13
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getColor() == null){
                System.err.println("调用BeanPostProcessor.postProcessBeforeInitialization() , color为空，设置为默认黄色");
                car.setColor("黄色");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getMaxSpeed() > 150){
                System.err.println("调用BeanPostProcessor.postProcessAfterInitialization() , 最大速度超过150，设置为150");
                car.setMaxSpeed(150);
            }
        }
        return bean;
    }
}
