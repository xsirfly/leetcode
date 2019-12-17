package xsir;

public class KthLargestElementinanArray {
    public static int findKthLargest(int[] nums, int k) {
        return findKth(nums, 0, nums.length - 1, k - 1);
    }

    private static int findKth(int[] nums, int start, int end, int k) {
        int pivot = nums[start];
        int i = start, j = end, idx = start + 1;
        while (i < j) {
            if (nums[idx] < pivot) {
                swap(nums, idx, j);
                j--;
            } else {
                swap(nums, idx, i);
                i++;
                idx++;
            }
        }
        nums[i] = pivot;
        if (i == k) {
            return pivot;
        } else if (i > k) {
            return findKth(nums, start, i - 1, k);
        } else {
            return findKth(nums, i + 1, end, k);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(findKthLargest(new int[]{99, 99}, 1));
    }
}
