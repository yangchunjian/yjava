package cn.yjava.demo.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * java最长不重复子串
 * 问题解释：
 * <p>
 * 在给定的字符串中找到最长的不含有重复字符的子串。
 * <p>
 * 解法1：暴力法
 * <p>
 * 遍历每一个字符作为子串的开始，然后不断扩展子串直到遇到重复的字符。
 * <p>
 * 解法2：滑动窗口
 * <p>
 * 使用两个指针表示当前的子串，当遇到重复字符时，将左指针向右移动直到不与重复字符重复。
 * <p>
 * 解法3：HashSet
 * <p>
 * 维护一个HashSet，存放已经遍历过的字符。
 * <p>
 * 解法4：ASCII
 * <p>
 * 如果字符串只包含小写字母，可以使用一个长度为128的数组来代替HashSet，数组下标对应ASCII码，值代表对应的字符是否出现过。
 * <p>
 * 解法5：动态规划
 * <p>
 * 使用dp[i]表示以第i个字符结尾的最长不含重复字符的子串的长度。
 * <p>
 * 以下是Java代码实现：
 */
public class 最长不重复子串 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring1(s);
        lengthOfLongestSubstring2(s);
        lengthOfLongestSubstring3(s);
        lengthOfLongestSubstring4(s);
        lengthOfLongestSubstring5(s);
    }

    //解法1：暴力法
    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                ans = Math.max(ans, set.size());
            }
        }
        return ans;
    }

    //解法2：滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0, left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            right++;
            ans = Math.max(ans, set.size());
        }
        return ans;
    }

    //解法3：HashSet
    public static int lengthOfLongestSubstring3(String s) {
        int ans = 0, left = 0, i = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (i < s.length() && !set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                i++;
            }
            ans = Math.max(ans, i - left);
        }
        return ans;
    }

    //解法4：ASCII
    public static int lengthOfLongestSubstring4(String s) {
        int ans = 0, left = 0, i = 0;
        int[] charMap = new int[128];
        while (i < s.length()) {
            if (i != 0) {
                charMap[s.charAt(i - 1)] = 0;
            }
            while (i < s.length() && charMap[s.charAt(i)] == 0) {
                charMap[s.charAt(i)]++;
                i++;
            }
            ans = Math.max(ans, i - left);
        }
        return ans;
    }

    //解法5：动态规划
    public static int lengthOfLongestSubstring5(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;

        for (int j = 0; j < n; j++) {
            dp[j] = 0;
            for (int i = 0; i < j; i++) {
                if (s.charAt(j) != s.charAt(i)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            ans = Math.max(ans, dp[j]);
        }

        return ans;
    }
}
