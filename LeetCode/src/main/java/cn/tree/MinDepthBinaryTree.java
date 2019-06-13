package cn.tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 *
 */
// TODO https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/
public class MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null || root.right == null) {
            return 1;
        }
        int dl = depth(root.left);
        int dr = depth(root.right);
        if (dl == 0 || dr == 0) {
            return Math.max(dl, dr);
        }
        return Math.min(dl, dr) + 1;
    }

    public int depth(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int lDepth = depth(root.left);
            int rDepth = depth(root.right);
            return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
        }
    }
}
