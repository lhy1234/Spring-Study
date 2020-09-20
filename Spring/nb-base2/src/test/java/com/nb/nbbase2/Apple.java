package com.nb.nbbase2;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * create by lihaoyang on 2020/9/3
 */
@Builder
@Data
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }
}