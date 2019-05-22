package cn.linklist;

/**
 * Created by super on 2019/5/22
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RDSL {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) return null;
        ListNode prev = head;
        ListNode next = head.next;
        while (prev != null && next != null) {
            if (prev.val == next.val) {
                prev.next = next.next;
                next = next.next;
            } else {
                prev = prev.next;
                next = next.next;
            }
        }
        return head;
    }


}
