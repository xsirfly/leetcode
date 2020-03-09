package xsir;

import java.util.Arrays;

public class DeleteandEarn {
    public static int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.sort(nums);
        int res;
        for (int i = 0; i < nums.length; i++) {
            res = dp[i] = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] == 0) {
                    res += nums[j];
                } else if (nums[i] - nums[j] == 1) {
                    dp[i] = Math.max(dp[i], dp[j]);
                } else {
                    dp[i] = Math.max(dp[i], dp[j] + res);
                }
                if (j == 0) {
                    dp[i] = Math.max(dp[i], nums[i] - nums[j] > 1 ? dp[j] + res : res);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
