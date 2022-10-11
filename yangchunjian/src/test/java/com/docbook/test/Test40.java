package com.docbook.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 11:46
 */
public class Test40 {
    public static void main(String[] args) {
        String input = "2020-05-16 19:20:34|user.login|name=Charles&location=Beijing&device=iPhone";

        String ret = doString(input);
        System.out.println("ret="+ret);
    }

    public static String doString(String input){
        int index = input.lastIndexOf("|");
        String org = input.substring(index+1);
        String[] orgArr = org.split("&");
        Map<String,String> map = new LinkedHashMap<>();
        for(String s : orgArr){
            String[] ss = s.split("=");
            map.put(ss[0],"\""+ss[1]+"\"");
        }

        return map.toString();
    }
}
