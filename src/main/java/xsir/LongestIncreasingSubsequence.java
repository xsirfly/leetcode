package xsir;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] mem = new int[nums.length];
        int max = 1;
        mem[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                mem[i] = Math.max(mem[i], nums[i] > nums[j] ? mem[j] + 1 : 1);
            }
            max = Math.max(mem[i], max);
        }
        return max;
    }
}
