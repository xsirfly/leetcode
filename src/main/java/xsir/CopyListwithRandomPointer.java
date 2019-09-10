package xsir;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        Map<Integer, Node> mem = new HashMap<>();
        return copyRandomList(head, mem);
    }

    private Node copyRandomList(Node node, Map<Integer, Node> mem) {
        if (node == null) {
            return null;
        }
        if (mem.get(node.val) != null) {
            return mem.get(node.val);
        }
        Node copy = new Node();
        copy.val = node.val;
        mem.put(node.val, copy);
        copy.next = copyRandomList(node.next, mem);
        copy.random = copyRandomList(node.random, mem);
        return copy;
    }
}
