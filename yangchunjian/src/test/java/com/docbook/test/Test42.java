package com.docbook.test;

import java.util.PriorityQueue;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 12:00
 */
public class Test42 {

    public static void main(String[] args) {
        int[] input = { 1,5,2,9,8,0,6};
        Double ret = doInput(input);
        System.out.println("ret="+ret);

    }


    public static Double doInput(int[] arr){
        //边界值
        if(arr == null || arr.length == 0){
            return null;
        }

        //考虑到arr长度为1时交由下面业务逻辑处理耗时也耗空间，此处做提前判断时间复杂度也才多O(1)
        if(arr.length == 1){
            return (double) arr[0];
        }

        // 默认是小顶堆，大顶堆为new PriorityQueue<>(Collections.reverseOrder())
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int length = arr.length;
        int k = length/2+1;

        for(int i = 0;i<k;i++){
            minPQ.add(arr[i]);
        }
        for(int i = k;i<length;i++){
            if(minPQ.peek() < arr[i]){
                minPQ.poll();
                minPQ.add(arr[i]);
            }
        }
        if (length % 2 == 0){
            return (minPQ.poll() + minPQ.peek())/ 2.0;
        } else{
            return minPQ.peek().doubleValue();
        }

    }
}
