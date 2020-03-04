package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BurstBalloons {
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        arr.add(1);
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; ++len) {
            for (int i = 1; i <= n - len + 1; ++i) {
                int j = i + len - 1;
                for (int k = i; k <= j; ++k) {
                    dp[i][j] = Math.max(dp[i][j], arr.get(i - 1) * arr.get(k) * arr.get(j + 1) + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][n];
    }

//    private static int makeCoins(List<Integer> ballons) {
//        if (ballons.isEmpty()) {
//            return 0;
//        }
//
//        int pre = 1, next = 1, cur, max = Integer.MIN_VALUE;
//        for (int i = ballons.size() - 1; i >= 0; i--) {
//            pre = i - 1 >= 0 ? ballons.get(i - 1) : 1;
//            next = i + 1 < ballons.size() ? ballons.get(i + 1) : 1;
//            cur = ballons.remove(i);
//            max = Math.max(max, pre * cur * next + makeCoins(ballons));
//            ballons.add(i, cur);
//        }
//        return max;
//    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }
}
