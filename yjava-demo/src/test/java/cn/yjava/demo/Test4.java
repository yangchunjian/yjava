package cn.yjava.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-09
 * @timed 15:46
 */
public class Test4 {

    public static void main(String[] args) {

        int[] input = {1,1,2,3,4,4,5,6};
//        int[] ret= getIndexArr(input,4);
//        System.out.println("ret="+ Arrays.toString(ret));
    }

//    public static int[] getIndexArr(int[] input,int target){
//        int left = 0;
//        int right = input.length-1;
//
//        while(left<=right){
//            while(left<=right && input[left] != target){
//                left++;
//            }
//
//            while(left<=right && input[right]!=target){
//                right--;
//            }
//    input[]
//            return new int[]{left,right};
//
//
//        }
//        return new int[]{-1,-1};
//
//
//    }

//    public static int[] getIndexArr(int[] input,int target){
//        int start = -1;
//        int count =-1;
//        boolean flag = false;
//        for(int i=0;i<input.length;i++){
//            if(input[i] == target){
//                if(!flag){
//                    start = i;
//                    flag = true;
//                }
//                count++;
//
//            }
//        }
//        if(start!=-1){
//            return new int[]{start,start+count};
//        }
//        return new int[]{-1,-1};
//
//    }


//    public static int[] getIndexArr(int[] input,int target){
//
//        int left =0;
//        int rigth = input.length-1;
//
//        while(left<=rigth){
//            int mid = left+(rigth-left)/2;
//            if(input[mid] == target){
//                rigth = mid;
//            }else if(input[mid]>target){
//                rigth = mid ;
//            }else if(input[mid]<target){
//                left = mid+1;
//
//            }
//
//
//        }
//        return new int[]{-1,-1};
//
//    }


}
