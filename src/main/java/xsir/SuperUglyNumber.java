package xsir;

import java.util.*;
import java.util.stream.Collectors;

public class SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        List<Integer> res = new ArrayList<>();
        res.add(1);
        Map<Integer, Integer> p2i = Arrays.stream(primes).boxed().collect(Collectors.toMap(v -> v, v -> 0));
        Map<Integer, Integer> p2r = new HashMap<>();
        int min;
        for (int i = 2; i <= n; i++) {
            min = Integer.MAX_VALUE;
            for (int p : primes) {
                int r = res.get(p2i.get(p)) * p;
                min = Math.min(r, min);
                p2r.put(p, r);
            }

            for (int p : primes) {
                if (p2r.get(p) == min) {
                    p2i.computeIfPresent(p, (k, v) -> v + 1);
                }
            }

            res.add(min);
        }
        return res.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
