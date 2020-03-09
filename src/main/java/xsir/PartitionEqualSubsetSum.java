package xsir;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][0] = dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = 0; k <= target; k++) {
                    if (dp[j][k]) {
                        dp[i][k] = true;
                        if (nums[i] + k <= target) dp[i][nums[i] + k] = true;
                    }
                }
            }
        }
        return dp[nums.length - 1][sum / 2];
    }

//    private static boolean find(int[] nums, int cur, int target) {
//        if (cur >= nums.length) {
//            return target == 0;
//        }
//        return find(nums, cur + 1, target) || find(nums, cur + 1, target - nums[cur]);
//    }

    public static void main(String[] args) {
//        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1, 1}));
    }
}
