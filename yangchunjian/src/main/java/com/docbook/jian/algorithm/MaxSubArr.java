package com.docbook.jian.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 * <p>
 * 最大子数组和
 * int[]数组中的最大子集，子集：数组中，数组下标连续的1个或者多个元素，形成的新数组；最大子集：和最大；例如：{1,2,3,4,5}其中{1}{1,2}{1,2,3}等是子集。要求写个方法，传入参数int[] i,返回参数：int类型最大子集的和

 */
public class MaxSubArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        int[] arr = {1,-2,3,-4,5};
//        int[] arr = {1,20,-1,20,5};
        int ret = maxSubArr(arr);
        System.out.println("arr="+ Arrays.toString(arr)+";ret="+ret);

    }

    public static int maxSubArr(int[] arr){
        int ret=0;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int tempEle = arr[i];
            for(int j=i+1;j<arr.length;j++){
                tempEle = Math.max(tempEle,tempEle+arr[j]);
            }


            temp.add(tempEle);
        }

        ret = Collections.max(temp);

        return ret;

    }


}
