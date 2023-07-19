package com.docbook.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test26 {

//    链表每n个节点翻转,不足n不翻转
//1->2-> 3-> 4-> 5
//    例子 n=2 res = 2-> 1-> 4-> 3-> 5
//    n=3 res = 3 ->2 ->1 ->4 ->5
//    static Node newHead;
    public static void main(String[] args) {

            Node n5 = new Node(null,5);
            Node n4 = new Node(n5,4);
            Node n3= new Node(n4,3);
            Node n2 = new Node(n3,2);
            Node n1 = new Node(n2,1);
            Node ret= doNode(n1,3);
            System.out.println("ret="+ret);


    }

    static Node doNode(Node node,int n){
        Node p = new Node(null,-1);
        p.next = node;
        Node head = node;
        int i=0;
        Node last = node;
        Node newHead=node;
        Node move = node;
        while(head!=null){
            if(i==n){
                Node revN = reverse(head);
                newHead.next = revN;
                revN.next = head;
                last = head.next;
                i=0;

            }
            head = head.next;
            i++;
        }

        if(i<n){
            head.next = last;
        }
        return p.next;

    }



    static Node reverse(Node head){
        if(head ==null){
            return null;
        }
        Node newHead = reverse(head.next);

        head.next.next = head.next;
        head.next = null;

        return newHead;
    }


    static  class Node {
        int val;
        Node next;


        Node(Node next,int val){
            this.val = val;
            this.next = next;

        }
    }

}
