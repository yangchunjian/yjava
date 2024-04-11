package cn.yjava.demo.algorithm; // 包声明

/**
 * 闰年是指年数能被4整除但不能被100整除，或者能被400整除的年份。
 */
public class 闰年 {  // 类声明

    public static void main(String[] args) {  // 主方法

    }

    public static boolean isLeapYear(int year) {  // 判断闰年的方法
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {  // 判断是否为闰年的条件
            return true;  // 返回true
        } else {
            return false;  // 返回false
        }
    }

}
