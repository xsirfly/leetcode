package xsir;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] mem = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (int)Math.sqrt(i); j++) {
                int newValue = mem[i - j * j] + 1;
                mem[i] = mem[i] == 0 ? newValue : Math.min(mem[i], newValue);
            }
        }
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(52));
    }
}
