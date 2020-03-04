package xsir;

public class BestTimetoBuyandSellStockwithCooldown {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];
        buy[0] = 0 - prices[0];
        sell[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            rest[i] = Math.max(buy[i - 1], Math.max(sell[i - 1], rest[i - 1]));
        }
        return Math.max(buy[prices.length - 1], Math.max(sell[prices.length - 1], rest[prices.length - 1]));
    }

//    private static int max(int[] prices, int curProfile, int curStock, int curDay, int status) {
//        if (curDay >= prices.length) {
//            return curProfile;
//        }
//        // cool down
//        if (status == 2) {
//            return max(prices, curProfile, curStock, curDay + 1, 0);
//        } else if (status == 0) {
//            int buy = max(prices, curProfile, prices[curDay], curDay + 1, 1);
//            int noBuy = max(prices, curProfile, curStock, curDay + 1, 0);
//            return Math.max(buy, noBuy);
//        } else {
//            int sellProfile = max(prices, curProfile + (prices[curDay] - curStock), 0, curDay + 1, 2);
//            int notSellProfile = max(prices, curProfile, curStock, curDay + 1, 1);
//            return Math.max(sellProfile, notSellProfile);
//        }
//    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

}
