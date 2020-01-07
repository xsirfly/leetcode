package xsir;

public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if (root.val <= max && root.val >= min) {
            return root;
        }
        if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}
