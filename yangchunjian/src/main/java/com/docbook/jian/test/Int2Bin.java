package com.docbook.jian.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 *
 * 10进制转成2进制
 */
public class Int2Bin {
    public static void main(String[] args) {

        int i = 10;
        String ret = Integer.toString(i,2);
        System.out.println("i="+i+";ret="+ret);

    }


}
