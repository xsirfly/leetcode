package xsir;

import java.util.*;

public class CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> mem = new HashMap<>();
        return cloneGraph(node, mem);
    }

    private Node cloneGraph(Node node, Map<Integer, Node> mem) {
        if (mem.get(node.val) != null) {
            return mem.get(node.val);
        }
        List<Node> neighbors = new ArrayList<>();
        Node copy = new Node(node.val, neighbors);
        mem.put(node.val, copy);
        for (Node n : node.neighbors) {
            neighbors.add(cloneGraph(n, mem));
        }
        return copy;
     }
}
