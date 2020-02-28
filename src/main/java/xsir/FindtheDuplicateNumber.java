package xsir;

import java.util.Arrays;

public class FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length;
        while (start < end) {
            final int mid = (start + end) >> 1;
            int count = (int)Arrays.stream(nums).filter(i -> i <= mid).count();
            if (count <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
