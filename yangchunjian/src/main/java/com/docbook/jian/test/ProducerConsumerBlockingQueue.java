package com.docbook.jian.test;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 生产者，消费者模式。多个生产者，多个消费者。注意三点：
 * 如果队列为空，则消费者阻塞
 * 如果队列满了，则生产者阻塞
 * 任何时候，只能有一个生产者或者消费者访问队列
 */
public class ProducerConsumerBlockingQueue {

    private static final int CAPACITY = 5;


    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(CAPACITY);
        Thread t1 = new Producer("P1",blockingDeque,CAPACITY);
        Thread t2 = new Producer("P2",blockingDeque,CAPACITY);
        Thread t3 = new Consumer("C1",blockingDeque,CAPACITY);
        Thread t4 = new Consumer("C2",blockingDeque,CAPACITY);
        Thread t5 = new Consumer("C3",blockingDeque,CAPACITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


    public static class Producer extends Thread {
        private LinkedBlockingDeque<Integer> blockingDeque;
        String name;
        int maxSize;
        int i = 0;


        public Producer(String name,LinkedBlockingDeque<Integer> queue,int maxSize){
            super(name);
            this.name = name;
            this.blockingDeque = queue;
            this.maxSize = maxSize;

        }


        @Override
        public void run(){
            while (true){
                try {
                    blockingDeque.put(i);
                    System.out.println(name+": Producing value:"+i);
                    i++;
                    Thread.sleep(new Random().nextInt(1000));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static class Consumer extends Thread {
        private LinkedBlockingDeque<Integer> blockingDeque;
        String name;
        int maxSize;
        int i = 0;


        public Consumer(String name,LinkedBlockingDeque<Integer> queue,int maxSize){
            super(name);
            this.name = name;
            this.blockingDeque = queue;
            this.maxSize = maxSize;

        }


        @Override
        public void run(){
            while (true){
                try {
                    int x = blockingDeque.take();
                    System.out.println(name+": Consuming value:"+x);

                    Thread.sleep(new Random().nextInt(1000));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}
