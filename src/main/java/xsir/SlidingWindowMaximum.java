package xsir;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
           return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = max(nums, i, i + k -1);
        }
        return res;
    }

    private int max(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }
}
