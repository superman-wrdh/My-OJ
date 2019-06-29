package cn.tree;

//https://leetcode.com/problems/diameter-of-binary-tree/

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

//最长路径可能不一定通过根节点
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left) + depth(root.right),
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
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

    /**
     * TODO 待改进
     * Success
     * Details
     * Runtime: 10 ms, faster than 6.58% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 39.2 MB, less than 21.74% of Java online submissions for Diameter of Binary Tree.
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));

    }
}
