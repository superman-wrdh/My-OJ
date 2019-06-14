package cn.linklist;

/**
 * Created by super on 2019/5/30
 * https://leetcode.com/problems/linked-list-cycle/
 * 循坏链表判断
 * 思路 将链表next指向同一个temp节点  head向前移动  重复操作
 * 若构成闭合 head移动到环时刻 head.next = temp
 *
 */
public class LinkListCycle {
    public boolean hasCycle(ListNode head) {
        if(null == head) return false;
        ListNode temp = new ListNode(-1);
        while (head.next != null){
            if(head.next == temp) return true;
            ListNode next = head.next;
            head.next = temp;
            head = next;
        }
        return false;
    }
}
