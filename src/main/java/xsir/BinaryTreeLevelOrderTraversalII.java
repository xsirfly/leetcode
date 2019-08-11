package xsir;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                res.add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            result.add(res);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> res = levelOrderBottom(node3);
        System.out.println(res);
    }

}
