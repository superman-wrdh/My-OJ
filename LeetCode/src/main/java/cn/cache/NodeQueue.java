package cn.cache;

public class NodeQueue {
    NodeQueue next;
    NodeQueue prev;
    Node tail;
    Node head;

    public NodeQueue(NodeQueue next, NodeQueue prev, Node tail, Node head) {
        this.next = next;
        this.prev = prev;
        this.tail = tail;
        this.head = head;
    }
}
