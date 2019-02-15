package cn.cache;

public class Node {
    int key;
    int value;
    int frequency = 0; //访问次数
    Node next; // 下一个元素
    Node prev; // 前一个元素
    NodeQueue nq;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
