package xsir;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int r2 = res.get(i2) * 2;
            int r3 = res.get(i3) * 3;
            int r5 = res.get(i5) * 5;
            int min = Math.min(r2, Math.min(r3, r5));
            if (min == r2) i2++;
            if (min == r3) i3++;
            if (min == r5) i5++;
            res.add(min);
        }
        return res.get(n - 1);
    }
}
