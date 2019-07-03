package cn.tree;

/**
 * Created by super on 2019/7/3
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class TwoSumIV {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        System.out.println(new TwoSumIV().findTarget(root,9));
        System.out.println(new TwoSumIV().findTarget(root,28));

    }


    public boolean findTarget(TreeNode root, int k) {
        return preTraverse(root, root, k);
    }

    public boolean preTraverse(TreeNode mainRoot, TreeNode root, int k) {
        if (root == null) return false;
        TreeNode m = search(mainRoot, k - root.val);
        if (m != null && m != root) return true;
        return preTraverse(mainRoot, root.left, k) | preTraverse(mainRoot, root.right, k);
    }

    public TreeNode search(TreeNode root, int v) {
        if (root == null || root.val == v) return root;
        if (root.val > v) return search(root.left, v);
        else return search(root.right, v);
    }
}
