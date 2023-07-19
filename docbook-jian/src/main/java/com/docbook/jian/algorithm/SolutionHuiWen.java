package com.docbook.jian.algorithm;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-20
 * @timed 22:15
 */
public class SolutionHuiWen {
    public static boolean isPalindrome(ListNode head) {
        ListNode node = head;
        System.out.println("node="+node);
        ListNode node1 = reverseList(head);
        System.out.println("node1="+head);
        while(node!=null && node1!=null){
            if(node.val!=node1.val){
                return false;
            }
            node = node.next;
            node1 = node1.next;

        }
        return true;
    }

    // 递归实现
     public static ListNode reverseList(ListNode head) {
         //1. 递归头  终止递归条件
         if(head==null || head.next==null){
             return head;
         }
         //2. 递归体  自顶向下深入
         ListNode newHead = reverseList(head.next);
         //3. 回溯    自底向上跳出
         head.next.next = head;
         head.next = null;


         return newHead;

     }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2,a);
        ListNode c = new ListNode(1,b);
        ListNode d = new ListNode(1,c);
        boolean ret = isPalindrome(d);
        System.out.println("ret="+ret);

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }


        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("->"+val);
            while(next!=null){
                sb.append("->"+next.val);
                next = next.next;
            }
            return sb.toString();
        }
    }
}

