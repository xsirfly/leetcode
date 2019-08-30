package xsir;

public class BinaryTreeMaximumPathSum {
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ResultHolder res = maxPath(root);
        return res.max;
    }

    public static class ResultHolder {
        public int max = Integer.MIN_VALUE;
        public int selectMax;
    }

    private static ResultHolder maxPath(TreeNode root) {
        ResultHolder res = new ResultHolder();
        if (root == null) {
            return res;
        }

        ResultHolder left = maxPath(root.left);
        ResultHolder rigth = maxPath(root.right);
        res.selectMax = Math.max(root.val, root.val + Math.max(left.selectMax, rigth.selectMax));
        int curMax = Math.max(root.val, Math.max(root.val + Math.max(left.selectMax, rigth.selectMax), root.val + left.selectMax + rigth.selectMax));
        res.max = Math.max(curMax, Math.max(left.max, rigth.max));
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        n1.left = n2;
//        n1.right = n3;
        System.out.println(maxPathSum(n1));
    }


}
