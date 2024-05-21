package cn.yjava.demo.algorithm; // 包声明

import java.util.LinkedList;
import java.util.Queue;

public class 完全二叉树 {  // 类声明
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        完全二叉树 checker = new 完全二叉树();
        System.out.println(checker.isCompleteBinaryTree(root));  // 输出：true/false，取决于传入的树是否为完全二叉树
    }

    public boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return true; // 空树被认为是完全二叉树
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isComplete = true;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                isComplete = false; // 左孩子为空但右孩子不为空，不是完全二叉树
            }

            if (node.right != null && isComplete) {
                queue.offer(node.right);
            }
        }

        return isComplete;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
