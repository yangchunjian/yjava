package cn.yjava.demo.algorithm; // 包声明

import java.util.LinkedList;
import java.util.Queue;

/**
 * 提供两种方法翻转二叉树的功能。
 */
public class 链表有环 {

    public boolean doNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // 慢指针每次向前移动一位
            fast = fast.next.next; // 快指针每次向前移动两位

            if (slow == fast) { // 如果快慢指针相遇，则说明链表有环
                return true;
            }
        }

        return false; // 若快指针到达链表末尾或遇到空节点，说明链表无环
    }

    // 定义链表节点类
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}


