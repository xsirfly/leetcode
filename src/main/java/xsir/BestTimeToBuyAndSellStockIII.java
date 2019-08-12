package xsir;

public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int[] left = new int[prices.length];
        left[0] = 0;
        int[] right = new int[prices.length];
        right[prices.length - 1] = 0;
        int min = prices[0], max = prices[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
            profit = Math.max(left[i], profit);
        }

        for (int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        for (int i = 1; i < prices.length - 1; i++) {
            profit = Math.max(profit, left[i] + right[i + 1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
