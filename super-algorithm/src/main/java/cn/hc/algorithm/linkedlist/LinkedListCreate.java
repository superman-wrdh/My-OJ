package cn.hc.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCreate {
    public static void main(String[] args) {
        LinkedListCreate creator = new LinkedListCreate();
        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1,2,3)));
    }
    /**
     * create a linked list
     * @param data  the data to create the list
     * @return head of the linked list ,linked list ends with last node whit getNext() = null
     */
    public Node createLinkedList(List<Integer> data){
        if(data.isEmpty()){
            return null;
        }
        Node firstNode = new Node(data.get(0));
        Node headOfSubList = createLinkedList(data.subList(1, data.size()));
        firstNode.setNext(headOfSubList);
        return firstNode;
    }

}
