package com.docbook.jian.algorithm;



public class Tree {

    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node5 = new TreeNode(5,null,node6);
        TreeNode node4 = new TreeNode(4, null,null);
        TreeNode node2 = new TreeNode(2, node3, node4);
        TreeNode h = new TreeNode(1, node2, node5);
        flatten(h);
        System.out.println("all="+h.toString());
    }
    public static void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        //
        flatten(root.left);
        flatten(root.right);
        // 后序遍历
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null){
            root = root.right;
            System.out.println("Root="+root.toString());
        }
        root.right = temp;
//        if(root.right!=null){
//
//            System.out.println("final="+root.right.toString());
//        }

    }
}
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

       @Override
       public String toString() {
           return "{" +
                   "val=" + val +
                   ", left=" + left +
                   ", right=" + right +
                   '}';
       }
   }
