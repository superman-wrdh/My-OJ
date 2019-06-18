package cn.linklist;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 1; i <= m; i++) {
            if (i == m) cur.next = reverseLen(cur.next, n - m + 1);
            cur = cur.next;
        }
        return dummy.next;
    }

    private ListNode reverseLen(ListNode head, int len) {
        if (len == 1) return head;
        ListNode cur = head;
        ListNode prev = null;
        while (len > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            len--;
        }
        head.next = cur;
        return prev;
    }
}
