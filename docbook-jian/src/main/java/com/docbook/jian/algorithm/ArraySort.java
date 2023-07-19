package com.docbook.jian.algorithm;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-09
 * @timed 12:23
 */
public class ArraySort {


    //移位数组，快速查找到target角标,
    //思路：如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
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
