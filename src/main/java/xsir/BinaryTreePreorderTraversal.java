package xsir;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode cur;
        while (!s.isEmpty()) {
            cur = s.pop();
            if (cur != null) {
                res.add(cur.val);
                s.push(cur.right);
                s.push(cur.left);
            }
        }
        return res;
    }

    private void pre(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        pre(root.left, res);
        pre(root.right, res);
    }
}
