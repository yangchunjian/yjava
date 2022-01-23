package com.docbook.jian.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 * 有序链表，如何去重，0->1->1->2->2->3->3->4->5->5->null
 */
public class DeleteDuplicatesListNode {
    public static void main(String[] args) {
        ListNode node9 = new ListNode(5,null);
        ListNode node8 = new ListNode(5,node9);
        ListNode node7 = new ListNode(4,node8);
        ListNode node6 = new ListNode(3,node7);
        ListNode node5 = new ListNode(3,node6);
        ListNode node4 = new ListNode(2,node5);
        ListNode node3 = new ListNode(2,node4);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node0 = new ListNode(0,node1);

        System.out.println("node0="+node0.toString());
        ListNode ret = delete(node0);
        System.out.println(";ret="+ret.toString());


    }

    static ListNode delete(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null){
            if(slow.element!=fast.element){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
//        slow.next = null;//最终指向null
        return head;


    }




    private static class ListNode {
        private int element;
        private ListNode next;

        public ListNode(int element, ListNode next) {
            this.element = element;
            this.next = next;
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

}
