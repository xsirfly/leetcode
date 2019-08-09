package xsir;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPIorder {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int i = Arrays.stream(inorder).boxed().collect( Collectors.toList() ).indexOf(preorder[preIndex]);
        root.left = buildTree(preorder, inorder, preIndex + 1, start, i - 1);
        root.right = buildTree(preorder, inorder, preIndex + (i - start + 1), i + 1, end);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
    }

}
