package xsir;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> dict = new HashSet<>();
        for (int n : nums) dict.add(n);
        int pre, next, max = Integer.MIN_VALUE;
        for (Integer n : nums) {
            pre = n;
            next = n + 1;
            while (dict.contains(pre)) {
                dict.remove(pre);
                pre--;
            }
            while(dict.contains(next)) {
                dict.remove(next);
                next++;
            }
            max = Math.max(max, next - pre - 1);
        }
        return max;

    }

    public static void main(String[] args) {
        int res = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(res);
    }
}
