package xsir;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = i - 1 >= 0 ? sum[i - 1] + nums[i] : nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? sum[j] : sum[j] - sum[i];
    }
}
