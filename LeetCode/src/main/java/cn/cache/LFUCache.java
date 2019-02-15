package cn.cache;


import java.util.HashMap;

public class LFUCache {
    private NodeQueue tail;
    private int capacity;
    private HashMap<Integer, Node> map;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 访问次数加1 记实录时间
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        //右移动 次数加1
        oneSetUp(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 在cache已满时，快速定位到访问次数最低且上次访问时间最早的key，将其移除
        // cache容量为0 不能写入数据 退出
        if (capacity == 0) {
            return;
        }
        Node exit = map.get(key);
        // 已经存在的值 直接更新 访问次数加1
        if (exit != null) {
            exit.value = value;
            oneSetUp(exit);
            return;
        }
        //cache容量已经满了 最尾部数据移除
        if (map.size() == capacity) {
            map.remove(removeNode(this.tail.tail).key);
        }
        //插入数据
        Node node = new Node(key, value);
        if (this.tail == null) {
            // tail为空说明 cache中没有元素 直接把node封装到NodeQueue里面加入
            NodeQueue nodeQueue = new NodeQueue(null, null, node, node);
            this.tail = nodeQueue;
            node.nq = nodeQueue;
        } else if (this.tail.tail.frequency == 0) {
            // 外层链表 尾部元素的访问次数是0 将node加入到外层链表尾部的头部
            node.prev = this.tail.head;
            this.tail.head.next = node;
            node.nq = this.tail;
            this.tail.head = node;
        } else {
            //外层链表尾部元素的访问次数不是0，那么实例化一个只包含此Node的NodeQueue，加入外层链表尾部
            NodeQueue nq = new NodeQueue(this.tail, null, node, node);
            this.tail.prev = nq;
            this.tail = nq;
            node.nq = nq;
        }

        // 将key和node放入map中
        map.put(key, node);
    }

    //访问时间 右移操作
    private void oneSetUp(Node n) {
        n.frequency++; //访问次数加1
        boolean singleNodeQ = false; // 为true时间代表 NodeQueue中只有一个node元素
        if (n.nq.head == n.nq.tail) {
            singleNodeQ = true;
        }
        if (n.nq.next != null) {
            if (n.nq.next.tail.frequency == n.frequency) {
                //右侧NodeQueue的访问次数与Node当前访问次数一样，将此Node置于右侧NodeQueue的头部
                removeNode(n); //从当前NodeQueue中删除Node
                //把Node插入到右侧NodeQueue的头部
                n.prev = n.nq.next.head;
                n.nq.next.head.next = n;
                n.nq.next.head = n;
                n.nq = n.nq.next;
            } else if (n.nq.next.tail.frequency > n.frequency) {
                //右侧NodeQueue的访问次数大于Node当前访问次数，则需要在两个NodeQueue之间插入一个新的NodeQueue
                if (!singleNodeQ) {
                    removeNode(n);
                    NodeQueue nnq = new NodeQueue(n.nq.next, n.nq, n, n);
                    n.nq.next.prev = nnq;
                    n.nq.next = nnq;
                    n.nq = nnq;
                }
                //如果当前NodeQueue中只有一个Node，那么其实不需要任何额外操作了
            }
        } else {
            //此NodeQueue的next == null，说明此NodeQueue已经位于外层链表头部了，这时候需要往外侧链表头部插入一个新的NodeQueue
            if (!singleNodeQ) {
                removeNode(n);
                NodeQueue nnq = new NodeQueue(null, n.nq, n, n);
                n.nq.next = nnq;
                n.nq = nnq;
            }
            //同样地，如果当前NodeQueue中只有一个Node，不需要任何额外操作
        }
    }

    private Node removeNode(Node n) {
        //如果NodeQueue中只有一个Node，那么移除整个NodeQueue
        if (n.nq.head == n.nq.tail) {
            removeNQ(n.nq);
            return n;
        }
        if (n.prev != null)
            n.prev.next = n.next;
        if (n.next != null)
            n.next.prev = n.prev;
        if (n.nq.head == n)
            n.nq.head = n.prev;
        if (n.nq.tail == n)
            n.nq.tail = n.next;
        n.prev = null;
        n.next = null;
        return n;
    }

    private void removeNQ(NodeQueue nq) {
        if (nq.prev != null)
            nq.prev.next = nq.next;
        if (nq.next != null)
            nq.next.prev = nq.prev;
        if (this.tail == nq)
            this.tail = nq.next;
    }


}


