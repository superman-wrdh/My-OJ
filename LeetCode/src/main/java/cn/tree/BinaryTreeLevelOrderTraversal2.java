package cn.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> l = new LinkedList<>();

        if (root == null) {
            return l;
        }

        levelOrderBottom(l, root, 1);

        Collections.reverse(l);

        return l;
    }

    private void levelOrderBottom(List<List<Integer>> l, TreeNode node, int level) {
        if (l.size() < level) {
            l.add(new ArrayList<>());
        }

        if (node.left != null) {
            levelOrderBottom(l, node.left, level + 1);
        }

        l.get(level - 1).add(node.val);

        if (node.right != null) {
            levelOrderBottom(l, node.right, level + 1);
        }
    }
}
