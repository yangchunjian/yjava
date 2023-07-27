package cn.yjava.demo;

import java.math.BigDecimal;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 11:19
 */
public class Base {

    public Base() {
        System.out.println("Base"); }
    public Base(int c) { System.out.println("Base--" + c);
    }


    public static void main(String[] args) {
        BigDecimal b = BigDecimal.ONE;
        A a = new A();

        do1(a);
        System.out.println("a="+a.getName());
//        System.out.println("b="+b);


    }

    static void do1(A a){
//        c = BigDecimal.TEN;
        System.out.println("c1="+a);
        a.setName("hello");

    }
    static void do1(BigDecimal c){
//        c = BigDecimal.TEN;
        System.out.println("c1="+c);
        c = c.add(BigDecimal.TEN);
        System.out.println("c="+c);
    }
    static class A{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
