package xsir;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromIPOrder {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length || postorder.length == 0) {
            return null;
        }
        return buildTree(postorder, inorder, postorder.length - 1, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] postorder, int[] inorder, int postIndex, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int i = Arrays.stream(inorder).boxed().collect( Collectors.toList() ).indexOf(postorder[postIndex]);
        root.right = buildTree(postorder, inorder, postIndex - 1, i + 1, end);
        root.left = buildTree(postorder, inorder, postIndex - (end - i) - 1, start, i - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(root);
    }

}
