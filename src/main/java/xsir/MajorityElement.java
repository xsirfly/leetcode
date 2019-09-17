package xsir;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length - 1) >> 1;
        return nums[mid];
    }
}
