package xsir;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangcong
 * @date 2019/4/29
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int size = 0;
        List<Integer> tmp = null;
        while (!q.isEmpty()) {
            if (size == 0) {
                size = q.size();
                if (tmp != null) {
                    res.add(tmp);
                }
                tmp = new ArrayList<>();
            }
            TreeNode n = q.poll();
            tmp.add(n.val);
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
