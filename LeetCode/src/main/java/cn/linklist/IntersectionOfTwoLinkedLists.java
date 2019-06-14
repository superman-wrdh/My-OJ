package cn.linklist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode temp = new ListNode(-1);
        while (headA.next != null) {
            ListNode next = headA.next;
            headA.next = temp;
            headA = next;
        }

        while (headB.next != null) {
            if (headB.next == temp) return null;
            ListNode next = headB.next;
            headB.next = temp;
            headB = next;
        }
        return null;
    }
}
