package cn.yjava.demo;

import java.util.PriorityQueue;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 11:53
 */
public class Test41 {

    public static void main(String[] args) {
//        int[] input = {-11, -5, -2, 7, 15, 20};
        int[] input = { 1,5,2,9,8,0,6};
//        int ret = doInput(input);
        Double ret = doInput(input);
        System.out.println("ret="+ret);
    }


//    public static int doInput(int[] input) {
//        if (input == null || input.length == 0) {
//            return Integer.MIN_VALUE;
//        }
//        int len = input.length;
//        if (input[0] >= 0) return input[0];//没有负数
//        if (input[len - 1] < 0) return input[len - 1];//没有正数
//        int mid = 0;
//        int begin = 0;
//        int end = len - 1;
//        int absMin = 0;
//
//        //数组中既有正数又有负数
//        while (true) {
//            mid = (begin + end) >>> 1;
//            if (input[mid] == 0) {
//                return 0;
//            } else if (input[mid] > 0) {
//                if (input[mid - 1] > 0) {
//                    end = mid - 1;
//                } else if (input[mid - 1] == 0) {
//                    return 0;
//                } else {
//                    break;
//                }
//            } else {
//                //如果值小于0，在数组右半部分查找
//                if (input[mid] + 1 < 0) {
//                    begin = mid + 1;
//                } else if (input[mid] + 1 == 0) {
//                    return 0;
//                } else {
//                    break;
//                }
//            }
//        }
//
//        if (input[mid] > 0) {
//            if (input[mid] < Math.abs(input[mid - 1])) {
//                absMin = input[mid];
//            } else {
//                absMin = input[mid - 1];
//            }
//        } else {
//            if (Math.abs(input[mid]) < input[mid + 1]) {
//                absMin = input[mid];
//            } else {
//                absMin = input[mid + 1];
//            }
//        }
//
//        return absMin;
//
//    }


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
