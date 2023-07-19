package com.docbook.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-24
 * @timed 15:29
 */
public class Test2 {
    /**
     * 给定一个偶数个元素的数组int[] n,要求数组元素随机两两组合成一个数对,每个元素只能使用一次.
     * 组合形成的数对和作为元素参与max运算得出结果,输出最小的max结果.
     * 举例: {5,3,5,2}
     * 第一种组合: (5,3)(5,2) , max(8,7) = 8
     * 第二种组合: (5,5)(3,2) , max(10,5) = 10
     * res = min(8,10) = 8
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String s1 = convert(s,numRows);
        System.out.println("##s1="+s1);

    }

    public static String convert(String s, int numRows) {
        String[] str = new String[numRows];
        for (int i = 0; i < numRows; i++) str[i] = "";
        int p = 0, n = s.length();
        while (p < n) {
            for (int i = 0; i < numRows && p < n; i++) str[i] += s.charAt(p++);
            for (int i = numRows - 2; i >= 1 && p < n; i--) str[i] += s.charAt(p++);
        }
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            if(str[i]==null){
                continue;
            }
            ans += str[i];
        }
        return ans;
    }

}
