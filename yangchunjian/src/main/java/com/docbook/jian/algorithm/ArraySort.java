package com.docbook.jian.algorithm;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-09
 * @timed 12:23
 */
public class ArraySort {


    //移位数组，快速查找到target角标
    public static void main(String[] args) {
        int[] i = {8,9,10,11,1,2,3};
        int index = search(i,2);
        System.out.println("index="+index);
    }


    static int search(int[] i,int target){


        int left = 0;

        int right = i.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(i[mid] == target){

                return mid;
            }else if(i[mid]<i[right]){
                if(i[mid]< target && target<=i[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }

            }else if(i[mid]>target){
                if(i[left]<=target && target<i[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }


            }
        }


        return -1;

    }


}
