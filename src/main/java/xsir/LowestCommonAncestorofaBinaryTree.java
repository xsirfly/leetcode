package xsir;

public class LowestCommonAncestorofaBinaryTree {
    private static class Result {
        TreeNode p;
        TreeNode q;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result res = new Result();
        return find(root, p, q, res);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q, Result result) {
        if (root == null) {
            return null;
        }

        TreeNode ancestor = find(root.left, p, q, result);
        if (ancestor != null) {
            return ancestor;
        }

        ancestor = find(root.right, p, q, result);
        if (ancestor != null) {
            return ancestor;
        }
        if (root == p) result.p = root;
        if (root == q) result.q = root;
        if (result.p != null && result.q != null) {
            return root;
        }

        return null;

    }
}
