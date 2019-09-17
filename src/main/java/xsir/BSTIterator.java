package xsir;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = s.pop();
        if (top.right != null) {
            TreeNode cur = top.right;
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
        }
        return top.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }
}
