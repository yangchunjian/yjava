package com.docbook.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test21 {

    public static void main(String[] args) {
//
        //未连续数组最长序列


        int[] temp = {0,3,7,2,5,8,4,6,0,1};
//        int[] temp = {100,4,200,1,3,2};

        int ret= doArr2(temp);
        System.out.println("ret="+ret);
    }


    public static int doArr(int[] nums){

        if(nums == null){
            return -1;
        }
        int ret = 1;
        int length = nums.length;

        Arrays.sort(nums);

        for(int j=0;j<length-1;j++){
            int i=1;
            while(nums[j]+1==nums[j+1]){
                i++;
                j++;
            }
            ret = Math.max(ret,i);
        }
        return ret;


    }



    public static int doArr2(int[] nums){

        if(nums == null){
            return -1;
        }
        int ret = 1;
        int length = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<length;i++){
            map.put(nums[i],i);
        }

        for(Integer i :nums){
            int j=1;
            while(map.containsKey(i+j)){
                j++;
            }
            if(j>ret){
                ret = j;
            }
        }
        return ret;


    }
}
