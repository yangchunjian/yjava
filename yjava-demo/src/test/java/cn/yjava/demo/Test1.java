package cn.yjava.demo;

import java.util.Date;
import java.sql.Timestamp;

public class Test1 {

    public static void main(String[] args) throws Exception {

        System.out.println(new Timestamp(new Date().getTime()));

    }

}