package com.docbook.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-03
 * @timed 15:35
 */
public class Test3_change_A_B {


    static Object obj = new Object();

    public static void main(String[] args) {

        int i = 10;
        A a = new A(i);
        B b = new B(i);
        a.start();
        b.start();


    }


    static class A extends Thread {
        int i;

        public A(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (i>0) {
                synchronized (obj) {

                    try {
                        obj.wait();
                        System.out.println("A: a");
                        i--;
                    } catch (Exception e) {

                    }


                }


            }
        }
    }

    static class B extends Thread {
        int i;

        public B(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            while (i>0) {
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj) {

                    try {
                        System.out.println("B: b");
                        i--;
                        obj.notify();
                    } catch (Exception e) {

                    }

                }

            }
        }
    }
}

