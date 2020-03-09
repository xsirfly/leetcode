package xsir;

import java.util.*;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[nums.length];
        dp[0] = 1;
        Arrays.sort(nums);
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            if ((dp[i] == max) && (res.isEmpty() || res.get(res.size() - 1) % nums[i] == 0)) {
                res.add(nums[i]);
                max--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1}));
    }
}
