package cn.yjava.demo.algorithm; // 包声明

import java.util.LinkedList;
import java.util.Queue;

/**
 * 提供两种方法翻转二叉树的功能。
 */
public class 二叉树反转 {  // 类声明

    /**
     * 递归方式翻转二叉树。
     *
     * @param root 二叉树的根节点。
     * @return 翻转后的二叉树的根节点。
     */
    public TreeNode invertTree(TreeNode root) {
        // 递归终止条件：空节点不需要反转，直接返回
        if (root == null) {
            return null;
        }

        // 递归反转左右子树
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        // 交换当前节点的左右子树
        root.left = rightInverted;
        root.right = leftInverted;

        // 返回反转后的当前节点
        return root;
    }

    /**
     * 使用队列迭代方式翻转二叉树。
     *
     * @param root 二叉树的根节点。
     * @return 翻转后的二叉树的根节点。
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 先将根节点入队

        // 使用队列迭代翻转二叉树
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 出队一个节点

            // 交换当前节点的左右子树
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // 将节点的原左右子节点（已交换）入队
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return root; // 返回反转后的根节点
    }

    // 定义二叉树节点
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
