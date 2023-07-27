package cn.yjava.demo;

import java.util.*;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test23 {

    //1+2+3
    public static void main(String[] args) {
        String input = "1+2+3";

        int ret1 = doStr(input);
        int ret2 = doStr2(input);
        String ret3 = doStr3(input);
        System.out.println("ret1=" + ret1);
        System.out.println("ret2=" + ret2);
        System.out.println("ret3=" + ret3);


    }


    public static int doStr(String input) {
        String[] str = input.split("\\+");

        int ret = 0;
        for (String num : str) {
            ret += Integer.parseInt(num);
        }
        return ret;
    }


    public static int doStr2(String input) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = input.length();
        int i = 0;
        while (i < n) {
            if (input.charAt(i) == ' ') {
                i++;
            } else if (input.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (input.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(input.charAt(i))) {
                    num = num * 10 + input.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }



    private static int number(char[] arr, int start, int end) {
        StringBuilder buffer = new StringBuilder();
        for (int i = start; i <= end; i++) {
            buffer.append(arr[i]);
        }
        return Integer.parseInt(buffer.toString());
    }


    private static int comp(String op) {
        if (op.equals("+") || op.equals("-"))
            return 1;
        if (op.equals("*") || op.equals("/"))
            return 2;
        return 0;
    }

    private static String compute(Integer a, Integer b, String op) {
        Integer res;
        if (op.equals("+")) {
            res = a + b;
            return res.toString();
        }
        if (op.equals("-")) {
            res = a - b;
            return res.toString();
        }
        if (op.equals("*")) {
            res = a * b;
            return res.toString();
        }
        if (op.equals("/") && b != 0) {
            res = a / b;
            return res.toString();
        } else {
            return "error";
        }
    }

    public static String doStr3(String input) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> ope = new Stack<>();
        ope.push(".");
        char[] exps = input.toCharArray();
        int start = 0;
        if (exps[0] == '-') {
            nums.push(0);
        }
        for (int j = 0; j < exps.length; j++) {
            if (exps[j] == '+' || exps[j] == '*' || exps[j] == '/' || exps[j] == '-') {
                if (start <= j - 1) {
                    nums.push(number(exps, start, j - 1));
                }
                start = j + 1;
                while (comp(ope.peek()) >= comp(String.valueOf(exps[j]))) {
                    Integer two = nums.peek();
                    nums.pop();
                    Integer one = nums.peek();
                    nums.pop();
                    String result = compute(one, two, ope.peek());
                    ope.pop();
                    if (result.equals("error")) {
                        return result;
                    }
                    nums.push(Integer.parseInt(result));
                }
                ope.push(String.valueOf(exps[j]));
            }
        }
        nums.push(number(exps, start, exps.length - 1));
        while (ope.size() > 1) {
            Integer two = nums.peek();
            nums.pop();
            Integer one = nums.peek();
            nums.pop();
            String op = ope.peek();
            ope.pop();
            String value = compute(one, two, op);
            if (value.equals("error")) {
                return value;
            }
            nums.push(Integer.parseInt(value));
        }
        return nums.peek().toString();
    }

}
