package com.docbook.test;

import java.util.*;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test {

    public static void main(String[] args) {
//        int star_idx = -1;
//        int i=0;
//
//        if(i==0){
//            star_idx = 10;
//        }else if(star_idx!=-1){
//            System.out.println("##");
//        }else {
//            System.out.println("##!!");
//        }
////        StringBuffer sb = new StringBuffer();
//        sb.
//        LinkedList sb = new LinkedList<>();
//        String ret = Integer.toBinaryString(12);
//        System.out.println("##ret="+ret);
////        Long.parseUnsignedLong()
////        ret.cha
//        ret.charAt()
//        Queue<Integer> q = new LinkedList<>();
//
////        q.
//        List<Character> a = new ArrayList<>();
//        a.indexOf()


//        String s ="1234";
//        s.startsWith();
//        s.length()
//        int a = s.charAt(3)-'0';
//        System.out.println("#a="+a);
    }


    public static String[] doIntArr(String[] i1,String[] i2){ //i1文，i2理
//        if(){
//
//        }
        Map<String,String> map = new LinkedHashMap<>();
//        List<String> list = new ArrayList<>();

        String ke1 = i1[0].toLowerCase();
        String ke2 = i2[0];
        String[] ke1s = ke1.split(",");
        String[] ke2s = ke2.split(","); //4

        Map<String,Integer> index = new LinkedHashMap<>();

        for(int i=0;i<ke1s.length;i++){
            ke1s[i] = ke1s[i].trim();
            map.put(ke1s[i],i+"");
        }

        int tempLi = ke1s.length;
        for(int i=0;i<ke2s.length;i++){
            if(!map.containsKey(ke2s[i])){
                map.put(ke2s[i],tempLi++ +"");
            }
            index.put(ke2s[i],Integer.parseInt(map.get(ke2s[i])));

        }
        int num = map.keySet().size();//科目的数量
//        int temp =0;

        //求ke1s和ke2差集数量；
//""
        String[] ret = new String[i1.length+i2.length-1];

        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()){
            sb.append(key+" ");
        }
        ret[0] = sb.toString().trim();


        for(int j=1;j<i1.length;j++){

            ret[j] = i1[j]+get0(num-ke1.length());
        }
        for(int j=1;j<i2.length;j++){
            String temp = i2[j];
            String[] tempArr = temp.split(" ");

            ret[i1.length+j] = "0";
        }

        return ret;

    }

    static String get0(int num){
        StringBuffer sb =new StringBuffer();


        for(int i=0;i<num;i++){
            sb.append("0 ");
        }


        return sb.toString().trim();
    }
}
