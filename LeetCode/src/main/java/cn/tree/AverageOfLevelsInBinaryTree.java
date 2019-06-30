package cn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> lists = levelOrder(root);
        List<Double> doubleList = new ArrayList<>();
        for (List<Integer> list : lists) {
            //doubleList.add((double) list.stream().reduce(Integer::sum).orElse(0) / (double) list.size());
            // 上面会有整形相加超出整形范围
            double sum = 0L;
            for (Integer i : list) {
                sum = sum + i;
            }
            doubleList.add(sum / (double) list.size());
        }
        return doubleList;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queen = new LinkedList<TreeNode>();
        queen.add(root);
        queen.add(null);
        List<Integer> sublist = new ArrayList<Integer>();
        while (queen.size() > 0) {
            TreeNode node = queen.remove();
            if (node != null) {
                sublist.add(node.val);
                if (node.left != null) {
                    queen.add(node.left);
                }
                if (node.right != null) {
                    queen.add(node.right);
                }
            } else {
                list.add(sublist);
                if (queen.size() > 0) {
                    sublist = new ArrayList<Integer>();
                    queen.add(null);
                }
            }
        }
        return list;
    }
}
