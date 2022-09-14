package com.docbook.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test24 {

    private static volatile int i;
    private Test24(int i){
        this.i = i;
    }

    private Test24(){
    }

    private static volatile Test24 instance;


    public static Test24 getInstance(){
        if(instance==null){
            synchronized (Test24.class){
                if(instance ==null){
                    instance = new Test24(10);
                }
            }
        }


        return instance;

    }
    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            Test24 instance = getInstance();
            System.out.println("instance"+i+":"+instance+":i="+instance.i);
        }


    }




}
