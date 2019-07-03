package cn.tree;

/**
 * Created by super on 2019/7/3
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIV {
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
