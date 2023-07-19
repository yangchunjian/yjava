package com.docbook.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test22 {

//    对一字符串，如：2A2B2C，解析字符串所包含的字母，并找出所有的排列组合。
//    备注：2A表示为2个A字母。
//
//    例如：
//    ABC的排列组合如下
//            ABC
//    ACB
//            BAC
//    BCA
//            CAB
//    CBA
    public static void main(String[] args) {
//

        //

        List<String> ret = doStr("2A2B2C");
        System.out.println("ret="+ ret.get(0) );
    }



    public static List<String> doStr(String input){
        List<String> ret = new ArrayList<>();
        char[] c = input.toCharArray();
        int j = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<c.length;i++){


            if(Character.isDigit(c[i])){
                j++;
            }else{


                String sub = subStr(Integer.parseInt(input.substring(i-j,i)),c[i]);
                j=0;
                sb.append(sub);
            }

        }
//               012345
//        sb //AABBCC //回溯


        ret.add(sb.toString());
        return ret;


    }



    public static String subStr(int i,char c){
        StringBuilder sb = new StringBuilder();

        for(int j=0;j<i;j++){
            sb.append(c);
        }

        return sb.toString();
    }






}
