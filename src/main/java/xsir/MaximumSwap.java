package xsir;

public class MaximumSwap {
    public static int maximumSwap(int num) {
        String n = String.valueOf(num);
        String res = n;
        char[] dp = new char[n.length()];
        int[] dpi = new int[n.length()];
        dp[n.length() - 1] = n.charAt(n.length() - 1);
        dpi[n.length() - 1] = n.length() - 1;
        for (int i = n.length() - 2; i >= 0; i--) {
            if (n.charAt(i) > dp[i + 1]) {
                dp[i] = n.charAt(i);
                dpi[i] = i;
            } else {
                dp[i] = dp[i + 1];
                dpi[i] = dpi[i + 1];
            }
        }
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) != dp[i]) {
                char[] arr = n.toCharArray();
                char tmp = arr[i];
                arr[i] = arr[dpi[i]];
                arr[dpi[i]] = tmp;
                res = new String(arr);
                break;
            }
        }
        return Integer.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }
}
