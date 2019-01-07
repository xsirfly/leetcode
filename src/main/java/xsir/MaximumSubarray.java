package xsir;

/**
 * @author zhangcong
 * @date 2019/1/7
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int preMax = nums[0], currentMax;
        for (int i = 1; i < nums.length; i++) {
            if (preMax > 0) {
                currentMax = preMax + nums[i];
            } else {
                currentMax = nums[i];
            }
            if (currentMax > max) {
                max = currentMax;
            }
            preMax = currentMax;
        }
        return max;
    }
    
    public static void  main(String[] args){
        int res = maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }

}
