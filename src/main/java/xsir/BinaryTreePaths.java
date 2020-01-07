package xsir;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        paths(root, res, null);
        return res;
    }

    private void paths(TreeNode root, List<String> res, String prefix) {
        if (root.left == null && root.right == null) {
            res.add(buildPath(prefix, root));
            return;
        }
        if (root.left != null) paths(root.left, res, buildPath(prefix, root));
        if (root.right != null) paths(root.right, res, buildPath(prefix, root));
    }

    private String buildPath(String prefix, TreeNode node) {
        return prefix == null ? String.valueOf(node.val) : prefix + "->" + node.val;
    }
}
