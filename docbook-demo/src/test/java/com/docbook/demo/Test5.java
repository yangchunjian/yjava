package com.docbook.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-10
 * @timed 17:29
 */
public class Test5 {

    //输入是字符串，返回没有重复字符的最长子串
    public static void main(String[] args) {

        String str=  "abcdsfsdfdsf";

        String output = doStr(str);
        System.out.println("##output="+output);


    }

    public static String doStr(String input){
        if(input == null || input==""){
            return "";
        }

        String output = input.charAt(0)+"";
        int length = 1;
        List<Character> temp  = new ArrayList<>();
        char[] ch = input.toCharArray();
        int j=0;
        for(int i=0;i<ch.length;i++){
            while(j<ch.length && j>=i){
                if(!temp.contains(ch[j])){
                    temp.add(ch[j]);
                }else{
                    if(length<temp.size()){
                        length = temp.size();
                        output = doString(temp);//集合返回每个字符

                    }
                    temp.clear();
                }
                j++;

            }

        }

        return output;



    }

    static String doString(List<Character> temp ){
        StringBuffer sb = new StringBuffer();
        for(char c : temp){
            sb.append(c);
        }
        return sb.toString();
    }

}
