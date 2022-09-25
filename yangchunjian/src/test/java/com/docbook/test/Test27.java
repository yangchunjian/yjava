package com.docbook.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */

/*
 问题：为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据（get）和写入数据（set），要求线程安全；

获取数据get(key)：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1
写入数据set(key, value)：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置
*/
public class Test27 {


    static Map<Integer,Integer> map;


    public Test27(Integer capacity){
        map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){

            @Override
            public boolean removeEldestEntry(Map.Entry entry){

                return  map.size() > capacity;

            }
        };

    }
    public static void main(String[] args) {

        Test27 t = new Test27(20);
        for(int i=0;i<20;i++){
            t.set(i,i);
        }

        for(int i=0;i<5;i++){
            t.set(i,i);
        }
        t.set(21,21);

        for(Integer key:map.keySet()){
            System.out.println("key="+key);
        }

    }




    static synchronized Integer get(int key){
        return map.getOrDefault(key,-1);
    }

    static synchronized void set(int key,int value){
        map.put(key,value);
    }



}
