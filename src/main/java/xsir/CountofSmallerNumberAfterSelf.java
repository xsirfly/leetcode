package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountofSmallerNumberAfterSelf {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> t = new ArrayList<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int s = 0, e = t.size();
            while (s < e) {
                int mid = s + (e - s) / 2;
                if (t.get(mid) >= nums[i]) {
                    e = mid;
                } else if (t.get(mid) < nums[i]) {
                    s = mid + 1;
                }
            }
            t.add(e, nums[i]);
            res[i] = e;
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }
}
