package xsir;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + minDepth(root.left);
        int right = 1 + minDepth(root.right);
        if (root.right == null) {
            return left;
        }
        if (root.left == null) {
            return right;
        }
        return Math.min(left, right);
    }
}
