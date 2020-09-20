package com.nb.nbbase2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

//管理Bean生命周期的接口
public class Car implements BeanFactoryAware,
        BeanNameAware,
        InitializingBean,
        DisposableBean {

    private String brand;
    private String color;
    private Integer maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car(){
        System.err.println("调用Car的构造函数...");
    }
    //BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.err.println("调用BeanFactoryAware.setBeanFactory()...");
        this.beanFactory = beanFactory;
    }

    //BeanNameAware接口方法
    @Override
    public void setBeanName(String beanName) {
        System.err.println("调用BeanNameAware.setBeanName()...");
        this.beanName = beanName;
    }
    //DisposableBean接口方法
    @Override
    public void destroy() throws Exception {
        System.err.println("调用DisposableBean.destroy()...");
    }
    //InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("调用InitializingBean.afterPropertiesSet()...");
    }

    //<bean>的init-method属性指定的方法
    public void myInit(){
        System.err.println("调用init-method所指定的myInit(),将maxSpeed设置为200...");
        this.maxSpeed = 200;
    }

    ////<bean>的destroy-method属性指定的方法
    public void myDestroy(){
        System.err.println("调用destroy-method所指定的myDestroy()...");
    }

    public void setBrand(String brand) {
        System.err.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public String getBrand() {
        return brand;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
