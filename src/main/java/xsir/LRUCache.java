package xsir;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        public int key;
        public int vale;
        public Node next;
        public Node pre;

        public Node() {
        }

        public Node(int key, int vale, Node next, Node pre) {
            this.key = key;
            this.vale = vale;
            this.next = next;
            this.pre = pre;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, Node> dict;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        dict = new HashMap<>(capacity);
    }

    public int get(int key) {

        return -1;
    }

    public void put(int key, int value) {
        if (size == 0) {
            head = new Node(key, value, null, null);
            tail = head;
            dict.put(key, head);
            size++;
        } else if (size == capacity - 1) {
            Node n = new Node(key, value, null, null);
            n.pre = tail.pre;
            tail.pre.next = n;
            dict.remove(tail.key);
            dict.put(key, n);
            tail = n;
        } else {
            Node n = new Node(key, value, null, null);
            n.pre = tail;
            tail.next = n;
            tail = n;
            dict.put(key, n);
            size++;
        }
    }
}
