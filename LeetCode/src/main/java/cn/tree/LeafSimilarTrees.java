package cn.tree;

import java.util.LinkedList;

/**
 * Created by super on 2019/7/3
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {
    LinkedList<Integer> list = new LinkedList<Integer>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        addLeaf(root1);
        return compareLeaf(root2);

    }

    /**
     * add leaf to the list , from left to right
     */
    public void addLeaf(TreeNode root){
        if(root.left != null) addLeaf(root.left);
        if(root.right != null) addLeaf(root.right);
        if(root.left == null && root.right == null) list.add(root.val);
    }

    /**
     * compare the value to the list node
     */
    public boolean compareLeaf(TreeNode root){

        boolean r = true,l = true;

        if(root.left != null) l = compareLeaf(root.left);
        if(root.right != null) r = compareLeaf(root.right);
        if(root.left == null && root.right == null){          // get leaf
            if(list.isEmpty()) return false;                            // if list is empty , return false
            return list.remove() == root.val;                     // remove and get list first node, compare to root.val
        }

        return l && r;
    }
}
