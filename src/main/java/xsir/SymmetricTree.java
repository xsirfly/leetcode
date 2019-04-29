package xsir;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author zhangcong
 * @date 2019/4/29
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }

    private static boolean isSymmetricChild(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val
                && isSymmetricChild(left.left, right.right)
                && isSymmetricChild(left.right, right.left);
        }
        return false;
    }

}
