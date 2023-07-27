package cn.yjava.demo;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈转队列
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */

public class Test29 {


    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();


    static LinkedList<Integer> l1;
    public Test29(){

    }

    public static void main(String[] args) {


    }


    public static void add(Integer i){
        s1.add(i);
    };




    public static void pop(){

        s1.pop();

    };

    LinkedList<Integer> doLinked(){
        return null;
    }

}
