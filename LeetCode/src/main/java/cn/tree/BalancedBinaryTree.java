package cn.tree;

/**
 * Created by super on 2019/5/26
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        else {
            return Math.abs(Math.abs(depth(root.left) - depth(root.right))) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }
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
