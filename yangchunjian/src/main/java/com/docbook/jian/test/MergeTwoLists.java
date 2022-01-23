package com.docbook.jian.test;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 * 表链序有的新个一成并合俩他把你请，表链序有个两入输你给
 * 0->1->2->4->5->null
 * 3->6->7->null
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(5,null);
        ListNode node3 = new ListNode(4,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode node0 = new ListNode(0,node1);


        ListNode node12 = new ListNode(7,null);
        ListNode node11 = new ListNode(6,node12);
        ListNode node10 = new ListNode(3,node11);

        System.out.println("node0="+node0.toString());
        ListNode ret = mergeTwoLists(node0,node10);
        System.out.println(";ret="+ret.toString());


    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1,null);
        ListNode p = dummy;

        while (p1!=null && p2!=null){
            if(p1.element>p2.element){
                p.next = p2;
                p2 = p2.next;
            }else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if(p1!=null){
            p.next = p1;
        }
        if(p2!=null){
            p.next = p2;

        }
        return dummy.next;
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
