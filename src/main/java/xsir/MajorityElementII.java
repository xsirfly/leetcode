package xsir;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0, cnt1 = 0, cnt2 = 0;
        for (int n : nums) {
            if (n == a) {
                cnt1++;
            } else if (n == b) {
                cnt2++;
            } else if (cnt1 == 0) {
                a = n; cnt1 = 1;
            } else if (cnt2 == 0) {
                b = n; cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; cnt2 = 0;
        for (int n : nums) {
            if (n == a) cnt1++;
            else if (n == b) cnt2++;
        }
        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) {
            res.add(a);
        }
        if (cnt2 > nums.length / 3) {
            res.add(b);
        }
        return res;
    }
}
