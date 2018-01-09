package cn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     *  leeteCode ->tree ->Binary Tree Level Order Traversal
     *  Given a binary tree, return the level order traversal of
     *  its nodes' values. (ie, from left to right, level by level).

         For example:
        Given binary tree [3,9,20,null,null,15,7],
        3
       /  \
     9   20
     /     \
    15     7
     return its level order traversal as:
     [
        [3],
        [9,20],
        [15,7]
     ]
     */
    static TreeNode root;
    static {
        /**
             3
           /  \
         9    20
        /       \
       15        7
      */
        root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));

        root.getLeft().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));
    }
    public static void main(String[] args) {
        SolutionBinaryTreeLevelOrderTraversal solution = new SolutionBinaryTreeLevelOrderTraversal();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionBinaryTreeLevelOrderTraversal{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
            return list;
        }
        LinkedList<TreeNode> queen = new LinkedList<TreeNode>();
        queen.add(root);
        queen.add(null);
        List<Integer> sublist = new ArrayList<Integer>();
        while (queen.size() > 0){
            TreeNode node = queen.remove();
            if(node != null){
                sublist.add(node.getVal());
                if(node.getLeft() != null){ queen.add(node.getLeft()); }
                if(node.getRight() != null){ queen.add(node.getRight()); }
            }else {
                list.add(sublist);
                if(queen.size() > 0){
                    sublist = new ArrayList<Integer>();
                    queen.add(null);
                }
            }
        }
        return list;
    }
}