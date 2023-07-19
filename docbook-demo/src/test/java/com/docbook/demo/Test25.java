package com.docbook.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-15
 * @timed 23:18
 */
public class Test25 {

    static int min = Integer.MAX_VALUE;
    static Node temp;
    public static void main(String[] args) {


//            5
//            /\
//            4 6
//            /
//            2
//            /\
//            1 3

        Node n3 = new Node(null,null,3);
        Node n1 = new Node(null,null,1);
        Node n2 = new Node(n1,n3,2);
        Node n6 = new Node(null,null,6);
        Node n4 = new Node(n2,null,4);
        Node n5 = new Node(n4,n6,5);



        Node ret = doNode(n5,7);
//        int ret = doNode(n5,7);

        System.out.println("ret="+ret.val);


    }

    //7
    public static Node doNode(Node n,int target){
        if(n == null){
            return temp;
        }
        if(n.val == target){
            return n;
        }
        if(Math.abs(n.val - target) < min){
            min =Math.abs(n.val - target);
            temp = n;
        }

        if(n.val>target){
            doNode(n.left,target);
        }else if(n.val < target){
            doNode(n.right,target);
        }

        return temp;
    }
//    //7
//    public static int doNode(Node n,int target){
//        if(n == null){
//            return min;
//        }
//        if(n.val == target){
//            return 0;
//        }
//        if(Math.abs(n.val - target) < min){
//            min =Math.abs(n.val - target);
//        }
//
//        if(n.val>target){
//            doNode(n.left,target);
//        }else if(n.val < target){
//            doNode(n.right,target);
//        }
//
//        return min;
//    }








    static class Node{
        Node left;
        Node right;
        int val;

        Node(Node left,Node right, int val){
            this.left = left;
            this.right = right;
            this.val = val;

        }



    }




}
