package xsir;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Set<Integer> hasComputedNums = new HashSet<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (hasComputedNums.contains(nums[i])) {
                continue;
            }
            List<List<Integer>> tmpResults = twoSum(hasComputedNums, nums, i);
            results.addAll(tmpResults);
            hasComputedNums.add(nums[i]);
        }
        return results;
    }

    private List<List<Integer>> twoSum(Set<Integer> hasComputedNums, int[] nums, int targetIndex) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        int start = 0, end = nums.length - 1;
        int target = 0 - nums[targetIndex];
        Set<String> hasComputed = new HashSet<String>();
        while (start < end) {
            if (start == targetIndex) {
                start++;
                continue;
            }
            if (end == targetIndex) {
                end--;
                continue;
            }
            int tmpRes = nums[start] + nums[end];
            if (tmpRes > target) {
                end--;
                continue;
            }
            if (tmpRes < target) {
                start++;
                continue;
            }
            if (tmpRes == target) {
                String str = Math.min(nums[start], nums[end]) + "" + Math.max(nums[start], nums[end]);
                if (!hasComputed.contains(str)) {
                    hasComputed.add(str);
                    if (!hasComputedNums.contains(nums[start]) && !hasComputedNums.contains(end)) {
                        results.add(Arrays.asList(nums[targetIndex], nums[start], nums[end]));
                    }
                }
                start++;
            }
        }
        return results;
    }
}
