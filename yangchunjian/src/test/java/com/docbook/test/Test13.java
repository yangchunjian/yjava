package com.docbook.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-16
 * @timed 14:15
 */
public class Test13 {


//    1.判断int型变量a是奇数还是偶数
//
//    a&1 == 0 偶数
//
//    a&1 == 1 奇数
    public static void main(String[] args) {
//        getBit(456,2);
//        getIntOddEven(233);
        System.out.println("##"+ -13%2); //-1
    }

//    private static void getBit(int num, int i){
//        int j =  (num & (1 << i));//true 表示第i位为1,否则为0
//        System.out.println("j="+j);
//
//    }


    static  boolean getIntOddEven(int i){
        int a =  i&1;
        System.out.println("a="+a);
        return  a == 1; // ==1基数 ==0偶数

    }

}


