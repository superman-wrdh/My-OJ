package cn.tree;

/**
 * Created by super on 2019/5/27
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) return false;
        sum = sum - root.val;
        if (null == root.left && null == root.right && sum == 0) return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
