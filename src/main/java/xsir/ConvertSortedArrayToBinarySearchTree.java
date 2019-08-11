package xsir;

public class ConvertSortedArrayToBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, start, mid - 1);
        root.right = build(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println(root);
    }
}
