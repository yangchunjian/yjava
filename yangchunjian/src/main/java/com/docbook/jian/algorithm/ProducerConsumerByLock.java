package com.docbook.jian.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者，消费者模式。多个生产者，多个消费者。注意三点：
 * 如果队列为空，则消费者阻塞
 * 如果队列满了，则生产者阻塞
 * 任何时候，只能有一个生产者或者消费者访问队列
 */
public class ProducerConsumerByLock {

    private static final int CAPACITY = 5;
    private static final Lock lock = new ReentrantLock();
    private static final Condition fullCondition = lock.newCondition(); //队列满的情况
    private static final Condition emptyCondition = lock.newCondition();//队列空的情况


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();


        Thread t1 = new Producer("P1", queue, CAPACITY);
        Thread t2 = new Producer("P2", queue, CAPACITY);
        Thread t3 = new Consumer("C1", queue, CAPACITY);
        Thread t4 = new Consumer("C2", queue, CAPACITY);
        Thread t5 = new Consumer("C3", queue, CAPACITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


    public static class Producer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;


        public Producer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;

        }


        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (queue.size() == maxSize) {

                    try {

                        System.out.println(name+":队列满了,数量"+queue.size());
                        fullCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name+":product value="+i);
                queue.offer(i++);
                // 唤醒其他所有生产者，消费者
                fullCondition.signalAll();
                emptyCondition.signalAll();

                lock.unlock();


                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class Consumer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;


        public Consumer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;

        }


        @Override
        public void run() {
            while (true) {

                lock.lock();
                while (queue.isEmpty()){
                    try {
                        System.out.println(name+":队列空了");
                        emptyCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                int x = queue.poll();

                System.out.println(name+":consumer value:"+x);
                fullCondition.signalAll();
                emptyCondition.signalAll();




                lock.unlock();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}
