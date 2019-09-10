package xsir;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s.push(root);
        TreeNode cur;
        while (!s.isEmpty()) {
            cur = s.peek();
            if (!s2.isEmpty() && s2.peek() == cur) {
                res.add(cur.val);
                s.pop();
                s2.pop();
                continue;
            }
            if (cur.left == null && cur.right == null) {
                res.add(cur.val);
                s.pop();
            } else {
                if (cur.right != null) {
                    s.push(cur.right);
                }
                if (cur.left != null) {
                    s.push(cur.left);
                }
                s2.push(cur);
            }
        }
        return res;
    }
}
