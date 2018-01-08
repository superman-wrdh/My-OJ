package cn.tree;

public class SymmetricTree {
    /**
     * leetCode ->Tree ->Symmetric Tree
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

     For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
            1
          /   \
        2     2
      / \    / \
     3   4  4   3
     But the following [1,2,2,null,3,null,3] is not:
       1
      / \
     2   2
     \    \
      3    3
     Note:
     Bonus points if you could solve it both recursively and iteratively.
     */
    static TreeNode root;
    static {
        /**
         * test case data
         *       1
         *      / \
         *     2   2
         *    /\   /\
         *   3 3  3  3
         */
        root= new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(2));

        root.getRight().setLeft(new TreeNode(3));
        root.getRight().setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(3));
        root.getLeft().setRight(new TreeNode(3));

//        root.getLeft().getLeft().setLeft(new TreeNode(5));
//        root.getRight().getRight().setRight(new TreeNode(5));
    }

    public static void main(String[] args) {
        SolutionSymmetricTree solution = new SolutionSymmetricTree();
        boolean result = solution.isSymmetric(root);
        System.out.println(result);
    }
}

class SolutionSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.getLeft() == null && root.getRight() == null)){
            return true;
        }
        return isSymmetric(root.getLeft(),root.getRight());
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        if(left.getVal()==right.getVal())
            return isSymmetric(left.getLeft(),right.getRight()) && isSymmetric(left.getRight(),right.getLeft());
        return false;
    }
}
