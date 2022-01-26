package com.docbook.jian.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-26
 * @timed 09:57
 */
public class SynchronizedDemo {
    public synchronized void f(){    //这个是同步方法
        System.out.println("Hello world");
    }
    public void g(){
        synchronized (this){		//这个是同步代码块
            System.out.println("Hello world");
        }
    }
    public static void main(String[] args) {

    }
}
