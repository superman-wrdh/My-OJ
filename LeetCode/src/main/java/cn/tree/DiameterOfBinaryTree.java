package cn.tree;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return depth(root.left) + depth(root.right);
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
