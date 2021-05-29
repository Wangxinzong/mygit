package com.wxz.mqapplication.main;

import java.math.BigDecimal;

public class MyMain {

    public static void main(String[] args){
        String budget = "999933";
        BigDecimal bigDecimal = new BigDecimal(budget);
        bigDecimal = bigDecimal.divide(new BigDecimal("100"));
        System.out.println(bigDecimal);
    }
}
