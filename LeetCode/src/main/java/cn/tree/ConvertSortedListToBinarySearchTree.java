package cn.tree;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head, fast = head, preSlow = head;
        while (fast != null && fast.next != null) {
            preSlow = slow; //one node ahead of slow
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        ListNode temp = slow.next;
        preSlow.next = null; //cut the linkedlist
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(temp);
        return root;
    }
}
