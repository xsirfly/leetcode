package xsir;

public class PalindromePartitioningII {
    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] p = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            p[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i -1])) {
                    dp[j][i] = true;
                    p[i] = j == 0 ? 0 : Math.min(p[i], p[j - 1] + 1);
                }
            }
        }
        return p[s.length() - 1];
    }

    public static void main(String[] args) {
        int res = minCut("aa");
        System.out.println(res);
    }
}
