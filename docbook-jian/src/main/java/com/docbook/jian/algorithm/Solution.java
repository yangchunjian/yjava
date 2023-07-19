package com.docbook.jian.algorithm;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-17
 * @timed 18:23
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || "".equals(s)){
            return 0;
        }
        int ret=Integer.MIN_VALUE;
        int length = s.length();
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(s.substring(i,j).indexOf(s.charAt(j))!=-1){
                    ret = Math.max(ret,(j-i));
                    break;
                }


            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String s ="au";
        int ret = lengthOfLongestSubstring(s);
        System.out.println("ret="+ret);

    }
}