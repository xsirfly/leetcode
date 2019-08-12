package xsir;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int size = 0;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                Node pre = q.poll();
                if (i != size - 1) {
                    pre.next = q.peek();
                }
                if (pre.left != null) {
                    q.add(pre.left);
                }
                if (pre.right != null) {
                    q.add(pre.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node n2 = new Node(2, null, null, null);
        Node n3 = new Node(3, null, null, null);
        Node n1 = new Node(1, n2, n3, null);
        Node n = connect(n1);
        System.out.println(n);
    }
}
