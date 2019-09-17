package xsir;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        TreeSet<Integer> t = new TreeSet<>();
        for (int n : nums) {
            t.add(n);
        }
        int max = 0;
        Iterator<Integer> iter = t.iterator();
        int pre = iter.next();
        int cur = 0;
        while (iter.hasNext()) {
            cur = iter.next();
            if (Math.abs(cur - pre) > max) {
                max = Math.abs(cur - pre);
            }
            pre = cur;
        }
        return max;
    }
}
