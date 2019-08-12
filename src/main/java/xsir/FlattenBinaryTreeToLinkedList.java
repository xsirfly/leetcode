package xsir;

public class FlattenBinaryTreeToLinkedList {
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode rightTmp = root.right;
        TreeNode lastLeft = root.left;
        while (lastLeft != null && lastLeft.right != null) lastLeft = lastLeft.right;
        root.right = root.left;
        root.left = null;
        if (lastLeft != null) {
            lastLeft.right = rightTmp;
        } else {
            root.right = rightTmp;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        flatten(n1);
        System.out.println(n1);
    }
}
