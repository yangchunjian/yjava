package com.docbook.demo;

import java.util.*;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-15
 * @timed 19:40
 */
public class Test_100 {
//    给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组。元素的 相对顺序 应该保持 一致 。
//    输入：nums = [0,0,1,1,1,2,2,3,3,4]
//    输出：nums = [0,1,2,3,4]

    public static void main(String[] args) {

        Integer[] input ={0,0,1,1,1,2,2,3,3,4};
        Integer[] ret= doIntArr(input);
        Integer[] ret1= doIntArr1(input);
        Integer[] ret2= doIntArr2(input);

        //数组转集合
        List<Integer> temp = Arrays.asList(ret2);

        //集合转数组
        Integer[] tempArr = temp.toArray(new Integer[ret2.length]);


        System.out.println("ret="+Arrays.toString(ret));
        System.out.println("ret1="+Arrays.toString(ret1));
        System.out.println("ret2="+Arrays.toString(ret2));

    }


    public static Integer[] doIntArr2(Integer[] input){

        if(input == null || input.length == 0){
            return input;
        }
        int length = input.length;
//        int[] ret = new int[length];
//        Arrays.fill(ret,Integer.MIN_VALUE);

//        ret[0] = input[0];
        int j=1;
        int i = 1;
        while (j<length-1 && i<length-1) {

            while(true){
                System.out.println("j="+j);
                if(input[j]==input[j-1]){
                    j++;
                }else{
                    break;
                }

            }
            if(j<length){
                input[i] = input[j];
            }
            i++;
        }

        input = Arrays.copyOfRange(input,0,i);

        return input;
    }



    public static Integer[] doIntArr1(Integer[] input){

        int length = input.length;
        Integer[] ret = new Integer[length];
        Arrays.fill(ret,Integer.MIN_VALUE);

        ret[0] = input[0];
        int j=1;
        int i = 1;
        while (j<length && i<length) {

            while(input[j]==input[j-1]){
                j++;
            }
            if(j<length){
                ret[i] = input[j];
            }

            i++;
        }

        ret = Arrays.copyOfRange(ret,0,i);

        return ret;
    }


    public static Integer[] doIntArr(Integer[] input){

        int length = input.length;

        Set<Integer> s = new HashSet<Integer>();
        for(Integer i:input){
            s.add(i);
        }

        Integer[] ret = new Integer[s.size()];

        List<Integer> l  =new ArrayList<>(s);
        for(int i=0;i<ret.length;i++){
            ret[i] = l.get(i);
        }
        return ret;
    }


}
