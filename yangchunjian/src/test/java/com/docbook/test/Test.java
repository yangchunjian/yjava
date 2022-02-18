package com.docbook.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test {

    public static void main(String[] args) {
        int star_idx = -1;
        int i=0;

        if(i==0){
            star_idx = 10;
        }else if(star_idx!=-1){
            System.out.println("##");
        }else {
            System.out.println("##!!");
        }
//        StringBuffer sb = new StringBuffer();
//        sb.
//        LinkedList sb = new LinkedList<>();
//        String ret = Integer.toBinaryString(12);
//        System.out.println("##ret="+ret);
////        Long.parseUnsignedLong()
////        ret.cha
//        ret.charAt()
//        Queue<Integer> q = new LinkedList<>();
//
////        q.
//        List<Character> a = new ArrayList<>();
//        a.indexOf()


        String s ="1234";

        int a = s.charAt(3)-'0';
        System.out.println("#a="+a);
    }
}
