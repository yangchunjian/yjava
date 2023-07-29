package cn.yjava.demo;

public class SwitchTest {
    public static void main(String[] args) {
        System.out.println(test(1));
        System.out.println(test(1.0));
        System.out.println(test(Float.valueOf(0.1f)));
    }


    static String test(Object o){
       return switch (o){
            case Integer i -> String.format("int %d",i);
            case Float l -> String.format("float %f",l);
            case String s -> String.format("string %s",s);
            default -> o.toString();
        };

    }
}
