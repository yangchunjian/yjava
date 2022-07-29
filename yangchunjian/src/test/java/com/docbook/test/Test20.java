package com.docbook.test;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test20 {

    public static void main(String[] args) {

        String input = "2022-08-26 00:00:00";

        Date date = new Date(1658390400000L); // 对应的北京时间是2017-08-24 11:17:10
//        Date date = new Date(1503544630000L); // 对应的北京时间是2017-08-24 11:17:10

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai")); // 设置北京时区

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo")); // 设置东京时区

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London")); // 设置伦敦时区

        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));
    }
}
