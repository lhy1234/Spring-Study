package com.nb.nbbase2.config;

import com.nb.nbbase2.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by lihaoyang on 2020/9/9
 */
@Configuration
public class BeansConfig {

    //默认方法名就是bean id
    @Bean
    public Car car(){
        Car car = new Car();
        car.setBrand("昌河");
        car.setColor("黄色");
        car.setMaxSpeed(200);
        car.myInit();
        return car;
    }
}
