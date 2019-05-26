package cn.tree;

/**
 * Created by super on 2019/5/26
 * https://leetcode.com/problems/same-tree/
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        else if (null == p || null == q) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
