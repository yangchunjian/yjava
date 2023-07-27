package cn.yjava.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-10-11
 * @timed 12:30
 */
public class Test43 {

    public static void main(String[] args) {

    }

    public int getResultByRecursion(int n){
        if (n <1) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int z = 1;
        int a = 1;
        int b = 2;
        int temp = 0;

        for (int i = 4; i < n+1 ; i++) {
            temp = a + b + z;
            z = a;
            a = b;
            b= temp;
        }
        return temp;
    }

//    public int getResultByRecursion(int n){
//        if (n <1) {
//            return 0;
//        }
//        if (n == 1){
//            return 1;
//        }
//        if (n == 2){
//            return 1;
//        }
//        if (n == 3){
//            return 2;
//        }
//        return getResultByRecursion(n-1) + getResultByRecursion(n-2)+ getResultByRecursion(n-3);
//    }
}
