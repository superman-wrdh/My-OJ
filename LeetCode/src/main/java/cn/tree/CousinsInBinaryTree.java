package cn.tree;

public class CousinsInBinaryTree {
    /**
     *https://leetcode.com/problems/cousins-in-binary-tree/
     *
     */
    public static void main(String[] args) {
        /**
         * [1,2,3,null,4,null,5]
         * 5
         * 4
         */
        /**
                  1
                /  \
              2     3
               \      \
                4     5
         */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        boolean isCousins = new CousinsInBinaryTree().isCousins(root, 5, 4);
        System.out.println(isCousins);

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int[] pair1 = new int[2];
        search(root, x, 0, -1, pair1);
        int[] pair2 = new int[2];
        search(root, y, 0, -1, pair2);
        return pair1[0] == pair2[0] && pair1[1] != pair2[1];
    }

    public void search(TreeNode root, int x, int depth, int parent, int[] res) {
        if (root != null) {
            if (root.val == x) {
                res[0] = x;
                res[1] = parent;
            } else {
                if(root.left != null) search(root.left, x, depth + 1, root.val, res);
                if(root.right != null) search(root.right, x, depth + 1, root.val, res);
            }
        }

    }
}
