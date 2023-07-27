package cn.yjava.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 11:19
 */
public class Derived extends Base {
    public Derived() {
        System.out.println("Derived"); }
    public Derived(int c) {
        super(c);
        System.out.println("Derived--" + c); }
    public static void main(String[] args) { Derived a = new Derived();
        Derived b = new Derived(33);
    } }