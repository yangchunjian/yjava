package cn.yjava.demo;


import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;

public class Test1 {

    public static void main(String[] args) throws Exception {

        System.out.println(new Timestamp(new Date().getTime()));

//        Object o = new BigDecimal(110.29);
//        BigDecimal o = new BigDecimal(100);
//
//        BigDecimal b = (BigDecimal)o;
//        System.out.println("##b"+b);

        BigDecimal o = new BigDecimal(902.28999);

        BigDecimal b= o.setScale(4,BigDecimal.ROUND_HALF_UP);

        System.out.println("#b="+b);
    }

}