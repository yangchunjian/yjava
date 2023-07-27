package cn.yjava.demo;

/**
 * 栈转队列
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */

public class Test30 {



    public static void main(String[] args) {
//        String str1 = "he" + "llo";
//        String str2 = "hello";
//        String str3 = new String("hello");
//        String str4 = new String("hello");
//        StringBuilder str5 = new StringBuilder("hello"); StringBuilder str6 = new StringBuilder("hello");
//        System.out.println(str1 == str2); System.out.println(str3 == str4); System.out.println(str5 == str6); System.out.println(str1.equals(str2)); System.out.println(str3.equals(str4)); System.out.println(str5.equals(str6));

        Thread t = new Thread() { public void run() {
            pong(); }
        };
        t.start(); System.out.print("ping");
    }
    static void pong() {
        try {
            Thread.sleep(1000); } catch (Exception e) {
            System.out.println(e); }
        System.out.print("pong"); }
}
