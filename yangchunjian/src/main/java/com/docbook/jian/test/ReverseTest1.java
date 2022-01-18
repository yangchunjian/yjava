package com.docbook.jian.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 */

/**
 * 把Excel的列名转成数字，比如 A - 0， B- 1，Z - 25 AA - 26， AZ - 51 BA - 52，AAA - 702
 * int getExcelNum(String colName){
 * <p>
 * }
 * 比如
 * 输入：A
 * 返回：0
 * 输入：AAA
 * 返回：702
 */
public class ReverseTest1 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
//         System.out.println("Hello World!");

//         //123
//         //321
        String input = "BA";
//         int ret = 321;
        int ret = doData(input);
//        int ret = doData("AAA");
        System.out.println("input=" + input + ";ret=" + ret);

    }
    // "BACZ"
    //

    static int doData(String colName) {
        double ret = 0;
        char[] ch = colName.toCharArray();
        for(int i=0;i<ch.length;i++){
            int temp = (ch[i]-'A');
//            ret = ret + temp * (26 ^(ch.length-i-1));
            ret = ret + (temp+1) * Math.pow(26,(ch.length-i-1));
        }
        ret = ret - 1;

        return (int) ret;

    }

}
