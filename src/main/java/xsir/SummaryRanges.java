package xsir;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start, end;
        start = nums[0]; end = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i- 1] != 1) {
                end = nums[i - 1];
                result.add(start == end ? String.valueOf(start) : start + "->" + end);
                start = nums[i];
            }
            if (i == nums.length - 1) {
                end = nums[i];
            }
        }
        result.add(start == end ? String.valueOf(start) : start + "->" + end);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
