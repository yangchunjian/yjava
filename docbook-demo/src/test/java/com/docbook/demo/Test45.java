package com.docbook.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 12:30
 */
public class Test45 {







    public static void main(String[] args) {

        int input = 8;

        boolean flag = doInt(input);
        boolean flag1 = doInt1(input);

        System.out.println("flag"+flag);
        System.out.println("flag1"+flag1);


    }



    public static boolean doInt(int input){


        return (input & (input-1))==0;



    }




    public static boolean doInt1(int input){

        while (input>=0){
            if(input == 2){
                return true;
            }
            int temp = input%2;
            input = input/2;
            if(temp!=0){
                return false;
            }

        }
        return true;



    }


}
