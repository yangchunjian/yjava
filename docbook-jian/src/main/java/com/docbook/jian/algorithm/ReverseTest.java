package com.docbook.jian.algorithm;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 */

/**
 *
 int(123) -》  int 321
 不能使用String Long
 +/-
 无法反转 0

 result = result * 10 + temp;
 */
public class ReverseTest {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
//         System.out.println("Hello World!");

//         //123
//         //321
         int input = 123;
//         int ret = 321;
         int ret = reverse(123);
        System.out.println("input="+input+";ret="+ret);

    }


    static int reverse(int input){

//            123 % 10 = 3
//             123 / 10 = 12
//         int temp = input % 10;
        StringBuilder sb = new StringBuilder();

        while(input>0){
            int temp = input % 10;
            sb.append(temp);
            input = input / 10;
        }


        return Integer.parseInt(sb.toString());

    }
}
