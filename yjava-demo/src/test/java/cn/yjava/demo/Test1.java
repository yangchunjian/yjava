package cn.yjava.demo;

public class Test1 {

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 300; i++) {
            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ThreadA");
                }
            });
            a.start();
            a.join();
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ThreadB");
                }
            });

            b.start();
            b.join();
            Thread c = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ThreadC");
                }
            });

            c.start();
            c.join();
        }


    }

}