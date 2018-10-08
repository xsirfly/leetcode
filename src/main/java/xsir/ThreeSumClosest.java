package xsir;

import java.util.Arrays;

/**
 * @author zhangcong
 * @date 2018/10/8
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start, end, currentDis, result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            end = nums.length - 1;
            while(start < end) {
                currentDis = nums[i] + nums[start] + nums[end] - target;
                if (currentDis == 0) {
                    return nums[i] + nums[start] + nums[end];
                }
                if (Math.abs(currentDis) < min) {
                    min = Math.abs(currentDis);
                    result = nums[i] + nums[start] + nums[end];
                }
                if (currentDis < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }

}
