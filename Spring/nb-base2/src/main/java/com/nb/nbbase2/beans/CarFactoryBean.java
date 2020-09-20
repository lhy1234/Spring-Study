package com.nb.nbbase2.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * create by lihaoyang on 2020/9/8
 */
public class CarFactoryBean implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
}
