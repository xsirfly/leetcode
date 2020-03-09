package xsir;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (arr1, arr2) -> arr1[0] - arr2[0]);
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                        || (envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1])) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(maxEnvelopes(new int[][] {
//                {1,15},{7,18},{7,6},{7,100},{2,200},{17,30},{17,45},{3,5},{7,8},{3,6},{3,10},{7,20},{17,3},{17,45}
//        }));
        System.out.println(maxEnvelopes(new int[][] {
                {7,8},{12,16},{12,5},{1,8},{4,19},{3,15},{4,10},{9,16}
        }));
    }
}
