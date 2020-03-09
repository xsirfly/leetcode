package xsir;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int lastSum = Arrays.stream(nums).limit(k).sum();
        int maxSum = lastSum;
        for (int i = 1; i < nums.length - k + 1; i++) {
            lastSum = lastSum - nums[i - 1] + nums[i + k - 1];
            maxSum = Math.max(maxSum, lastSum);
        }
        return (double)maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{4, 2, 1, 3, 3}, 2));
    }
}
