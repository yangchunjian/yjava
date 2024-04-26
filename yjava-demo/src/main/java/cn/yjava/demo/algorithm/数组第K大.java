package cn.yjava.demo.algorithm; // 包声明

public class 数组第K大 {  // 类声明

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        int result = getKthMax(a, k);
        System.out.println(result);
    }

    public static int getKthMax(int[] a, int k) {
        int max = a[0];
        for (int i = 1; i < a.length;i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        for (int i = max; i >= 0; i--) {
            if (count[i] > 0) {
                k -= count[i];
                if (k <= 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
