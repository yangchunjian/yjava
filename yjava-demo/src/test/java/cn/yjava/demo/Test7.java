package cn.yjava.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-11
 * @timed 17:47
 */
public class Test7 {


//    N个有序数组取 topK
//    N = 3 , K = 4
//
//            [10，9， 8， 7]
//            [9, 6, 5, 3]
//            [7,2,1]
//
//    返回 10， 9， 9， 8


    public static void main(String[] args) {

        int[][] input = new int[][]{};
//        int [] ret = doData(input);

    }


    public static int[] doData(int[][] input, int k) {

        List<List<Integer>> temp = new ArrayList<>();
        for (int[] i : input) {
            temp.add(toList(i));

        }

        int m = 0;
        List<Integer> tempList = new ArrayList<>();
        while (m < temp.size()) {
            List<Integer> list = temp.get(m);
            for (int i = 0; i < Math.min(list.size(), k); i++) {
                int t = list.get(i);
                tempList.add(t);
            }
            m++;
        }

        Collections.sort(tempList);
        Collections.reverse(tempList);
        List<Integer> result = tempList.subList(0, Math.min(k, tempList.size()));

        return array(result);
    }




    static int[] array(List<Integer> a) {
        int[] ret = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            ret[i] = a.get(i);

        }

        return ret;
    }

    static List<Integer> toList(int[] a) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ret.add(a[i]);

        }

        return ret;
    }
}
