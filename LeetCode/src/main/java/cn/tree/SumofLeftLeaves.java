package cn.tree;

import sun.reflect.generics.tree.Tree;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumofLeftLeaves {
    /**
     * [3,9,20,null,null,15,7]
     * 3
     * / \
     * 9  20
     * / \
     * 15  7
     *
     * @param args
     */
    public static void main(String[] args) {


    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)return 0;
        return leftSum(root.left, true) + leftSum(root.right, false);
    }

    public int leftSum(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int sum = 0;
        if (isLeft) {
            if (root.left == null || root.right == null) {
                return sum + root.val;
            }
        } else {
            if (root.left != null) return sum + leftSum(root.left, true);
            if (root.right != null) return sum + leftSum(root.right, false);
        }
        return sum;
    }

}
