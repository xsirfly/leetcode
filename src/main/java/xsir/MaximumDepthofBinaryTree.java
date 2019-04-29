package xsir;

/**
 * @author zhangcong
 * @date 2019/4/29
 */
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHight = 1 + maxDepth(root.left);
        int rightHight = 1 + maxDepth(root.right);
        return Math.max(leftHight, rightHight);
    }

}
