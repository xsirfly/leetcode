package xsir;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if ((mid - 1 < 0 || nums[mid - 1] < nums[mid])
                    && (mid + 1 >= nums.length || nums[mid + 1] < nums[mid])) {
                return mid;
            }
            if (mid + 1 < nums.length && nums[mid + 1] < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }
}
