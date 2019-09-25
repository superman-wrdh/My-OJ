package cn.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees2 {
    /**
     * https://leetcode.com/problems/leaf-similar-trees/
     */
    /**
     *          3
     *       /     \
     *      5          1
     *    /  \        /   \
     *   6    2     9      8
     *      /  \
     *     7   4
     * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
     * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
     * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
     * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
     * Note:
     * Both of the given trees will have between 1 and 100 nodes.
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(8);

        root.left.left=new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> leaf = new LeafSimilarTrees2().getLeaf(root, list);
        System.out.println(leaf);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        List<Integer> leaf1 = getLeaf(root1, list1);
        List<Integer> leaf2 = getLeaf(root2, list2);
        return leaf1.toArray().equals(leaf2.toArray());
    }

    public List<Integer> getLeaf(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) list.add(root.val);
        if (root.left != null) getLeaf(root.left, list);
        if (root.right != null) getLeaf(root.right, list);
        return list;
    }
}
