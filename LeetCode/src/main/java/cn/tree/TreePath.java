package cn.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by super on 2019/5/27
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class TreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        return binaryTreePaths(root, paths, "");
    }

    public List<String> binaryTreePaths(TreeNode root, List<String> paths, String path) {
        if (null == root) return paths;
        path += root.val;
        if (null == root.left && null == root.right) paths.add(path);
        else path += "->";
        binaryTreePaths(root.left, paths, path);
        return binaryTreePaths(root.right, paths, path);
    }
}
