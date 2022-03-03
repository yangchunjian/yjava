package com.docbook.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-03
 * @timed 15:35
 */
public class Test3_change_A_B_LockSupport {


    static Thread a = null;
    static Thread b = null;
    public static void main(String[] args) throws Exception{
        a = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    LockSupport.park();
                    System.out.println(Thread.currentThread().getName()+":B");
                    LockSupport.unpark(b);
                }
            }
        });
        b = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    LockSupport.unpark(a);
                    System.out.println(Thread.currentThread().getName()+":A");
                    LockSupport.park();

                }
            }
        });
        a.start();
        b.start();

    }

    static class Task implements Runnable{

        int i=0;
        @Override
        public synchronized void run() {
            for(int j=0;j<20;j++){
                if(i %2 == 0){
                    System.out.println(Thread.currentThread().getName()+":A");
                }else {
                    System.out.println(Thread.currentThread().getName()+":B");
                }

                i++;
                this.notifyAll();
                try {
                    Thread.sleep(100);
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }



}

