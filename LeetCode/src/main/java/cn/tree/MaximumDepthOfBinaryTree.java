package cn.tree;

public class MaximumDepthOfBinaryTree {
    /**
     * leetCode ->Tree -> Maximum Depth of Binary Tree
     *  Given a binary tree, find its maximum depth.
        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    static TreeNode root;
    static {
        /**
         * test case data
         *       0
         *      /\
         *     1  2
         *       /\
         *      3  4
         */
        root= new TreeNode(0);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(2));
        root.getRight().setLeft(new TreeNode(3));
        root.getRight().setRight(new TreeNode(4));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.maxDepth(root);
        System.out.println(result);
    }

}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()));
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

