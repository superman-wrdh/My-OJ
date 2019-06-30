package cn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
