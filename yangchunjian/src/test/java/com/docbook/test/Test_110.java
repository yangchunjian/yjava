package com.docbook.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-15
 * @timed 19:40
 */
public class Test_110 {

    //1分，2分，5分，组成100分，组成方法有多少种

    public static void main(String[] args) {

    }


    public static int doInt(int target){
        int ret= 0;

        int i1 = 1;
        int i2 = 2;
        int i5 = 5;

        for(int i=0;i<=100/1;i=i+1){
            int iSum = i1 * i;
            for(int j=0;j<=100/2;j=j+1){
                int jSum = i2 * j;


                for(int z=0;z<=100/5;z=z+1){
                    int zSum = i5 * z;
                    if(target == iSum+jSum+zSum){
                        ret++;
                    }
                    if(target > iSum+jSum+zSum){
                        break;
                    }
                }

            }

        }


        return ret;


    }

    public static int helper(int[] input,int target){

        return 0;
    }







}
