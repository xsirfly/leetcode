package xsir;

public class MinimumCostForTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        int[][] dp = new int[days.length + 1][days.length + 1];
        for (int len = 1; len <= days.length; len++) {
            for (int i = 1; i <= days.length - len + 1; i++) {
                int j = i + len -1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = j; k >= i; k--) {
                    int dayGrap = days[j - 1] - days[k - 1] + 1;
                    if (dayGrap > 30) {
                        continue;
                    }
                    if (dayGrap == 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + Math.min(costs[0], Math.min(costs[1], costs[2])));
                    } else if (dayGrap <= 7) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + Math.min(costs[1], costs[2]));
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + costs[2]);
                    }
                }
            }
        }
        return dp[1][days.length];
    }

    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{7, 2, 15}));
//        System.out.println(mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2, 7, 15}));
    }
}
