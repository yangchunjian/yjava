package cn.yjava.demo;

/**
 * @author Yang Chunjian
 * @email 1091938307@qq.com
 * @created 2022-03-16
 * @timed 14:15
 */
public class Test12 {
    // 给定二叉树，节点值只有0、1，删除所有不包含1的子树
// eg.
// input:
//                1
//            /        \
//         0              0
//      /     \       /       \
//    1        1      0        0
//   /
//  0
// output:
//                1
//            /
//         0
//      /     \
//    1        1
//
//
// input:
//    1
//         \
//            0
//        /       \
//        0        1
//
//
// output:
//    1
//         \
//            0
//               \
//                 1
//



// input:
//    1
//         \
//            0
//        /       \
//        0        0
//
//
// output:
//    1



    public static TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left == null && root.right==null && root.val == 0){
            return null;
        }
        if(isO(root)){
            return null;
        };

        TreeNode l = root.left;
        TreeNode r = root.right;
        if(l!=null){
            boolean isl = isO(l);
            root.left = isl?null:l;
        }

        if(r!=null){
            boolean isr = isO(r);
            root.right = isr?null:r;

        }

        pruneTree(root.left);
        pruneTree(root.right);
        return root;


    }

    public static void main(String[] args) {
        TreeNode tree = generateCase1();
        System.out.println("##tree="+tree.toString());

        TreeNode tn = pruneTree(tree);
        System.out.println("##tree0="+tn.toString());

    }




    static boolean isO(TreeNode node){ //树是否都是0
        if(node == null){
            return true;
        }

        if(node.val != 0){
            return false;
        }

        return isO(node.left) && isO(node.right);

    }


    private static TreeNode generateCase1() {
        TreeNode n3 = new TreeNode(1, null, null);
        TreeNode n2 = new TreeNode(0, null, null);
        TreeNode n1 = new TreeNode(0, n2, n3);
        TreeNode n0 = new TreeNode(1, null, n1);
        return n0;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


