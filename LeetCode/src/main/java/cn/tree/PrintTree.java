package cn.tree;

import java.util.ArrayList;

/**
 * '''
 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * '''
 * <p>
 * '''
 * 广度优先层次遍历，利用一个队列来实现
 * 层序遍历的基本过程是：
 * 先根节点入队，然后：
 * 1.从队列中取出一个元素
 * 2.访问该元素所指的结点
 * 3.若该元素所指结点的左、右孩子结点非空，则将其左、右孩子的指针顺序入队
 */
public class PrintTree {
    static TreeNode root;

    static {
        /**
         6
         /  \
         9    20
         /       \
         15        7
         */
        root = new TreeNode(6);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));

        root.getLeft().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));
    }

    public static void main(String[] args) {
        printTree(root);

    }

    public static void printTree(TreeNode root) {
        ArrayList<TreeNode> treeList = new ArrayList<>();
        ArrayList<Integer> valueList = new ArrayList<>();
        treeList.add(root);
        for (int i = 0; i < treeList.size(); i++) {
            TreeNode node = treeList.get(i);
            if (node.left != null) {
                treeList.add(node.left);
            }
            if (node.right != null) {
                treeList.add(node.right);
            }
            valueList.add(node.val);
        }

        System.out.println(valueList);
    }


}
