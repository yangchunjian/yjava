package com.docbook.jian.algorithm;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-02-16
 * @timed 18:35
 *             /
 *
 *             H
 *           /  \
 *          D   G
 *          /\   \
 *         B C   F
 *          \    /
 *          A   E
 *              /
 *              I
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    protected Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    /**
     * 构造树
     */
    public static Node init() {
        Node a = new Node('A');
        Node b = new Node('B', null, a);
        Node c = new Node('C');
        Node d = new Node('D', b, c);
        Node i = new Node('I');
        Node e = new Node('E', i, null);
        Node f = new Node('F', e, null);
        Node g = new Node('G', null, f);
        Node h = new Node('H', d, g);
        return h;// root
    }

    /**
     * 访问节点
     */
    public static void visit(Node p) {
        System.out.print(p.getKey() + " ");
    }

    // 求二叉树的高度
    static int height(Node tree) {
        if (tree == null) {
            return 0;
        } else {
            int leftTreeHeight = height(tree.getLeft());
            int rightTreeHeight = height(tree.getRight());
            ;
            return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1 : rightTreeHeight + 1;
        }
    }

    // 求二叉树的结点总数
    static int nodes(Node tree) {
        if (tree == null) {
            return 0;
        } else {
            int left = nodes(tree.getLeft());
            int right = nodes(tree.getRight());
            return left + right + 1;
        }
    }

    // 求二叉树叶子节点的总数
    static int leaf(Node tree) {
        if (tree == null) {
            return 0;
        } else {
            int left = leaf(tree.getLeft());
            int right = leaf(tree.getRight());
            if (tree.getLeft() == null && tree.getRight() == null) {
                return left + right + 1;
            } else {
                return left + right;
            }
        }
    }

    //将二叉树所有结点的左右子树交换
    static void swapTree(Node root) {
        if (root != null) {
            Node tmp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(tmp);
            swapTree(root.getLeft());
            swapTree(root.getRight());
        }
    }

    /**
     * getLeafNodes: 递归求解给定二叉树的所有叶子结点
     *
     * @param root     给定二叉树的根结点
     * @param leaflist 给定二叉树的所有叶子结点
     */
    static void getLeafNodes(Node root, List leaflist) {
        if (root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                leaflist.add(root);
                return;
            }
            getLeafNodes(root.getLeft(), leaflist);
            getLeafNodes(root.getRight(), leaflist);
        }
    }

    /**
     * longestPath: 递归求解给定二叉树的一条最长路径 如果有多条，输出其中一条
     *
     * @param root        给定二叉树的根结点
     * @param longestPath 存放二叉树的最长路径上的结点
     */
    static void longestPath(Node root, List longestPath) {
        if (root != null) {
            longestPath.add(root);
            if (root.getLeft() == null && root.getRight() == null) { // 左右子树均空
                return;
            }
            List leftLongestPath = new ArrayList();
            List rightLongestPath = new ArrayList();
            longestPath(root.getLeft(), leftLongestPath);
            longestPath(root.getRight(), rightLongestPath);
            if (leftLongestPath.size() >= rightLongestPath.size()) {
                longestPath.addAll(leftLongestPath);
            } else if (leftLongestPath.size() < rightLongestPath.size()) {
                longestPath.addAll(rightLongestPath);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(init());
        System.out.println("叶子结点数");
        System.out.println(leaf(tree.getRoot()));
        System.out.println("总结点数");
        System.out.println(nodes(tree.getRoot()));
        System.out.println("树的高度");
        System.out.println(height(tree.getRoot()));
        System.out.println();
        System.out.println("一条最长路径");
        List l = new ArrayList();
        longestPath(tree.getRoot(), l);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(((Node) l.get(i)).getKey());
        }
    }

}

class Node {
    private char key;
    private Node left, right;

    public Node(char key) {
        this(key, null, null);
    }

    public Node(char key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}