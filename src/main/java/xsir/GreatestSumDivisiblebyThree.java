package xsir;

import java.util.Arrays;

public class GreatestSumDivisiblebyThree {
    public static int maxSumDivThree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[3];
        for (int num : nums) {
            int[] tmp = Arrays.copyOf(dp, dp.length);
            for (int i : tmp) {
                dp[(i + num) % 3] = Math.max(dp[(i + num) % 3], i + num);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3,6,5,1,8}));
    }
}

