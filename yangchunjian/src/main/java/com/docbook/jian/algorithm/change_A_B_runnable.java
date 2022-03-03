package com.docbook.jian.algorithm;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-03
 * @timed 15:35
 */
public class change_A_B_runnable {


    static Object obj = new Object();

    public static void main(String[] args) {
        Task t = new Task();
        new Thread(t).start();
        new Thread(t).start();


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

