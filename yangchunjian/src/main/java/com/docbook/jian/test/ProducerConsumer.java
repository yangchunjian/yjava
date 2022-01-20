package com.docbook.jian.test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 生产者，消费者模式。多个生产者，多个消费者。注意三点：
 * 如果队列为空，则消费者阻塞
 * 如果队列满了，则生产者阻塞
 * 任何时候，只能有一个生产者或者消费者访问队列
 */
public class ProducerConsumer {

    private final Deque<Integer> deque = new ArrayDeque<>();
    private int MAX_COUNT = 10;


    public void produce() {

        while (true) {
            synchronized (deque) {
                while (deque.size() == MAX_COUNT) { // while重要，不要用if。// 多生产者和多消费者的情况下，这里判断是否空（满）不能用if，要用while，否则队列长度会超出MAX_COUNT
                    System.out.println(Thread.currentThread().getName() + "队列满了，不能再生产了");
                    try {
                        deque.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                deque.addLast(1);
                System.out.println(Thread.currentThread().getName() + "生产1个，当前数量：" + deque.size());
                deque.notifyAll(); // 在多生产者和多消费者的情况下，这里可能唤醒另外一个因为队列满了而阻塞的生产者线程，如果上面是if，则会导致队列长度超出MAX_COUNT
            }
        }
    }


    public void consume() {

        while (true) {
            synchronized (deque) {
                while (deque.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "队列空了，不能再消费了");

                    try {
                        deque.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                deque.pollFirst(); // 消费
                System.out.println(Thread.currentThread().getName() + "消费1个，当前数量：" + deque.size());
                deque.notifyAll(); // 在多生产者和多消费者的情况下，这里唤醒只能唤醒生产者

            }
        }

    }


    public static void main(String[] args) {


        final ProducerConsumer producerConsumer = new ProducerConsumer();

        for (int i = 0; i < 5; i++) {
            new Thread("thread-consumer" + i) {

                @Override
                public void run() {
                    producerConsumer.consume();
                }
            }.start();

        }


        for (int i = 0; i < 5; i++) {
            new Thread("thread-producer" + i) {
                @Override
                public void run() {
                    producerConsumer.produce();
                }
            }.start();
        }
    }


}
