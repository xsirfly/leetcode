package xsir;

public class FindMinimuminRotatedSortedArray {
    public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (mid == start && nums[mid] < nums[end] ) {
                return nums[mid];
            }
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                return nums[mid];
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {2, 1}));
    }
}
