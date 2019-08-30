package xsir;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int currentSum) {
        if (root == null) {
            return currentSum;
        }
        if (root.left == null && root.right == null) {
            return currentSum * 10 + root.val;
        }
        if (root.left == null) {
            return sumNumbers(root.right, currentSum * 10 + root.val);
        }
        if (root.right == null) {
            return sumNumbers(root.left, currentSum * 10 + root.val);
        }
        return sumNumbers(root.right, currentSum * 10 + root.val)
                + sumNumbers(root.left, currentSum * 10 + root.val);
    }
}
