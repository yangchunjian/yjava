package com.docbook.jian.algorithm;

import java.util.Arrays;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 * <p>
 * 1、数据里有{1,2,3,4,5,6,7,8,9}，请随机打乱顺序，生成一个新的数组（请以代码实现）
 */

public class RandomMain { //随机打乱

    public static int[] srand(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            //随机获取下标
            int tmp = (int) (Math.random() * (a.length - i));
            int change = a[a.length - i - 1];
            a[a.length - i - 1] = a[tmp];
            a[tmp] = change;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(srand(a)));
    }

 }

