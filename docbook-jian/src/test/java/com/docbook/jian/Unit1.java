package com.docbook.jian;

import java.util.Arrays;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-23
 * @timed 09:51
 */
public class Unit1 {

    /**
     * 反转字符串数组
     * @param args
     */
    public static void main(String[] args) {
        String[] input = {"123","234","345"};
        String[] output = doStringArr(input);
        System.out.println("input="+ Arrays.toString(input)+";output="+Arrays.toString(output));

    }

    public static String[] doStringArr(String[] input){
        if(input==null || input.length==0){
            return input;
        }


        int length = input.length;
        int mid = 0;
        if(length % 2 == 0 ){
            mid = length /2;
        }else{
            mid = length /2+1;
        }
        String[] output = new String[length];
        for(int i=0;i<length;i++){
            output[i] = input[length-1-i];

        }

        return output;
    }



//    public static String[] doStringArr(String[] input){
//        if(input==null || input.length==0){
//            return input;
//        }
//
//        int length = input.length;
//        String[] output = new String[length];
//        for(int i=0;i<length;i++){
//            output[i] = input[length-1-i];
//
//        }
//
//        return output;
//    }

}
