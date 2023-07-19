package com.docbook.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 11:19
 */
public class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB"); }
    { System.out.println("I'm B class"); }
    static { System.out.println("static B"); }
    public static void main(String[] args) {
        new HelloB();
    } }