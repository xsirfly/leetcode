package xsir;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangcong
 * @date 2019/4/29
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int size = 0;
        List<Integer> tmp = null;
        boolean l2r = false;
        while (!q.isEmpty()) {
            if (size == 0) {
                size = q.size();
                if (tmp != null) {
                    res.add(tmp);
                }
                tmp = new LinkedList<>();
                l2r = !l2r;
            }
            TreeNode n = q.poll();
            if (l2r) {
                tmp.add(n.val);
            } else {
                tmp.add(0, n.val);
            }
            size--;
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        res.add(tmp);
        return res;
    }

}
