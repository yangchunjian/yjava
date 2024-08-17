package cn.yjava.demo;


import netscape.javascript.JSObject;

import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;

public class Test1 {

    public static void main(String[] args) throws Exception {

        System.out.println(new Timestamp(new Date().getTime()));

//        Object o = new BigDecimal(110.29);
//        BigDecimal o = new BigDecimal(100);
//
//        BigDecimal b = (BigDecimal)o;
//        System.out.println("##b"+b);

        BigDecimal o = new BigDecimal(902.28999);

        BigDecimal b= o.setScale(4,BigDecimal.ROUND_HALF_UP);

        System.out.println("#b="+b);

        Set<String> s = new HashSet<>();
        s.add("001");
        s.add("002");

        List<A> alist = new ArrayList<>();
        for(int i=0;i<10;i++){
            A a = new A();
            a.setA("00"+i);
            alist.add(a);
        }
        System.out.println("alist="+ alist.size());

        Iterator<A> at = alist.iterator();
        while(at.hasNext()){
            A aa = at.next();
            if(!s.contains(aa.getA())){
                at.remove();
            }
        }

        System.out.println("alist after="+ alist.size());
    }

    static class A{
        private String a;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}