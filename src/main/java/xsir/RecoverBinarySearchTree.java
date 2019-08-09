package xsir;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecoverBinarySearchTree {
    public static void recoverTree(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        inorderTrans(root, order);
        List<Integer> shouldOrder = new ArrayList<>(order);
        shouldOrder.sort(Comparator.naturalOrder());
        inorderReplace(root, shouldOrder, 0);
    }

    private static void inorderTrans(TreeNode root, List<Integer> order) {
        if (root == null) {
            return;
        }
        inorderTrans(root.left, order);
        order.add(root.val);
        inorderTrans(root.right, order);
    }

    private static int inorderReplace(TreeNode root, List<Integer> shouldOrder, int cur) {
        if (root == null) {
            return cur;
        }
        if (root.left != null) {
            cur = inorderReplace(root.left, shouldOrder, cur);
        }
        if (root.val != shouldOrder.get(cur)) {
            root.val = shouldOrder.get(cur);
        }
        cur++;
        if (root.right != null) {
            cur = inorderReplace(root.right, shouldOrder, cur);
        }
        return cur;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n3.left = n1;
        n3.right = n4;
        n4.left = n2;
        recoverTree(n3);
        System.out.println(n3);
    }
}
