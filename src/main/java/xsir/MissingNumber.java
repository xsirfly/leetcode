package xsir;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int shouldSum = ((nums.length + 1) * nums.length) / 2;
        int sum = Arrays.stream(nums).sum();
        return shouldSum - sum;
    }
}
