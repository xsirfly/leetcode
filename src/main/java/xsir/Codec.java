package xsir;

import java.util.ArrayDeque;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue q = new ArrayDeque();
        q.add(root);
        while (!q.isEmpty()) {
            Object cur = q.poll();
            if (cur instanceof TreeNode) {
                TreeNode curNode = (TreeNode)cur;
                sb.append(',').append(curNode.val);
                q.add(curNode.left == null ? "N" : curNode.left);
                q.add(curNode.right == null ? "N" : curNode.right);

            } else if (cur instanceof String) {
                sb.append(',').append((String)cur);
            }
        }
        return sb.toString().substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int cur = 1;
        while (cur < arr.length) {
            TreeNode parent = q.poll();
            String left = arr[cur];
            String right = arr[cur + 1];
            if (!left.equals("N")) {
                TreeNode leftNode  = new TreeNode(Integer.valueOf(left));
                parent.left = leftNode;
                q.add(leftNode);
            }
            if (!right.equals("N")) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(right));
                parent.right = rightNode;
                q.add(rightNode);
            }
            cur += 2;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two; root.right = three;
        three.left = four; three.right = five;

        Codec c = new Codec();
        String res = c.serialize(root);
        System.out.println(res);
        TreeNode root2 = c.deserialize("1,2,3,N,N,4,5,N,N,N,N");
        System.out.println(root2);
    }
}
