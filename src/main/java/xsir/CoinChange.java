package xsir;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    if (dp[i] <= 0) {
                        dp[i] = 1 + dp[i - coin];
                    } else {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }
}
