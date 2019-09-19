package com.se;

import org.junit.Test;

import java.math.BigDecimal;

public class NumberUtil {

    @Test
    public void demo1(){
        // BigDecimal 执行数值操作时,返回新对象
        BigDecimal totalPrice = new BigDecimal("1.00");
        BigDecimal salePrice = new BigDecimal("7.20");
        int buyQty = 3;
        totalPrice.add(salePrice.multiply(new BigDecimal(String.valueOf(buyQty))));
        System.out.println("totalPrice:"+totalPrice.add(salePrice.multiply(new BigDecimal(String.valueOf(buyQty)))));
    }

}
