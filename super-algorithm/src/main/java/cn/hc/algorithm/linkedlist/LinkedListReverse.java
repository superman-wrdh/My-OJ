package cn.hc.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListReverse {
    public Node reverseLinkedList(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }
        Node newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;

    }
    public static void main(String[] args) {
        LinkedListCreate creator = new LinkedListCreate();
        LinkedListReverse reverse = new LinkedListReverse();
        Node.printLinkedList(reverse.reverseLinkedList(creator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(reverse.reverseLinkedList(creator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(reverse.reverseLinkedList(creator.createLinkedList(Arrays.asList(1,2,3))));
    }
}
