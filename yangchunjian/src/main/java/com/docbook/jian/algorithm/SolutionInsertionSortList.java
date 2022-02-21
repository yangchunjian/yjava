package com.docbook.jian.algorithm;

import java.util.Stack;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-17
 * @timed 18:23
 */
public class SolutionInsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode p = dummy;
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            ListNode q = head;
            head = head.next;
            q.next = p.next;
            p.next = q;

        }

        return dummy.next;

    }

    public static void main(String[] args) {
        String s = "au";
        int ret = lengthOfLongestSubstring(s);
        System.out.println("ret=" + ret);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("->"+val);
        if(next!=null){
            sb.append("->"+next.val);
        }
        return sb.toString();
    }


}