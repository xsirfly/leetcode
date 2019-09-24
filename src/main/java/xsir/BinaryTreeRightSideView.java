package xsir;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int size;
        TreeNode node;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.poll();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return res;
    }
}
