package com.docbook.jian.test;

import java.util.PriorityQueue;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-01-10
 * @timed 15:16
 * 合并K个有序链表
 * 0->1->2->4->5->null
 * 3->6->7->null
 */
public class MergeKLists {
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
        ListNode[] nodeList = {node0,node10};

        ListNode ret = mergeKLists(nodeList);
        System.out.println(";ret="+ret.toString());


    }

    static ListNode mergeKLists(ListNode[] nodeList){

        ListNode dummy = new ListNode(-1,null);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(nodeList.length,(a,b)->(a.element-b.element));
        for(ListNode node :nodeList){
            if(node!=null){
                pq.add(node);
            }
        }

        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if(node.next!=null){
                pq.add(node.next);
            }
            // p指针不断向前
            p = p.next;
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
