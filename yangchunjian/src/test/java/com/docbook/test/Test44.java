package com.docbook.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 12:30
 */
public class Test44 {



    private Test44(){
    }

    public static volatile Test44 instance;


    public static Test44 getInstance(){

        if(instance == null){

            synchronized (Test44.class){
                if(instance == null){
                    instance = new Test44();
                }
            }

        }
        return instance;

    }




    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            Test44 t = Test44.getInstance();
            System.out.println("##"+t.toString());
        }

    }

}
