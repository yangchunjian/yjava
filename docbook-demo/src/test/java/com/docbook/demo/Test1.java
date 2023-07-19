package com.docbook.demo;

import java.util.Arrays;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-24
 * @timed 15:29
 */
public class Test1 {
    /**
     * 给定一个偶数个元素的数组int[] n,要求数组元素随机两两组合成一个数对,每个元素只能使用一次.
     组合形成的数对和作为元素参与max运算得出结果,输出最小的max结果.
     举例: {5,3,5,2}
     第一种组合: (5,3)(5,2) , max(8,7) = 8
     第二种组合: (5,5)(3,2) , max(10,5) = 10
     res = min(8,10) = 8
     * @param args
     */
    public static void main(String[] args) {
        int[] n ={5,3,5,2};
        int ret = doData(n);
        System.out.println("#ret="+ret);
    }


    public static int doData(int[] n){

        if(n.length==0){
            return 0;
        }
        int len = n.length;
        Arrays.sort(n); // 2 3 5 5
        int newLen = len/2;
        int[] n1 = new int[len/2]; //2
//        int[] n2 = new int[len/2];

        int sum0=0;
        for(int i : n){
            sum0+= n[i];
        }
        int index = 0;
        int sum1 = 0;
        for(int i=0;i<newLen;i++){

            n1[i] = n[index];
            index = n.length - index-1;
            sum1+= n1[i];
        }

        int sum2 = sum0-sum1;


        int ret = Integer.MIN_VALUE;
        int temp = 0;


        temp = Math.max(sum1,sum2);

        ret = Math.min(ret,temp);



        return ret;






    }

}
