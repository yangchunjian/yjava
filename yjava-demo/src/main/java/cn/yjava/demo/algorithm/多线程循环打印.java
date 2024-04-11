package cn.yjava.demo.algorithm; // 包声明

/**
 *
 */
public class 多线程循环打印 {  // 类声明
    private volatile int number = 1;
    private final int maxNumber;

    public 多线程循环打印(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public static void main(String[] args) {
        多线程循环打印 多线程循环打印 = new 多线程循环打印(10);

        Thread oddThread = new Thread(() -> {
            while (多线程循环打印.number <= 多线程循环打印.maxNumber) {
                synchronized (多线程循环打印) {
                    if (多线程循环打印.number % 2 != 0) {
                        System.out.println("Odd Thread: " + 多线程循环打印.number);
                        多线程循环打印.number++;
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (多线程循环打印.number <= 多线程循环打印.maxNumber) {
                synchronized (多线程循环打印) {
                    if (多线程循环打印.number % 2 == 0) {
                        System.out.println("Even Thread: " + 多线程循环打印.number);
                        多线程循环打印.number++;
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
