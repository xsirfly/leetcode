package xsir;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int start = 0, end = 0, res = nums[start];
        while (start <= end && end < nums.length) {
            if (res < s) {
                end++;
                if (end >= nums.length) {
                    break;
                }
                res += nums[end];
            } else {
                res -= nums[start];
                min = Math.min(end - start + 1, min);
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(100, new int[]{2,3,1,2,4,3, 7}));
    }
}
