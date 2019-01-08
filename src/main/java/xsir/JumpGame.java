package xsir;

/**
 * @author zhangcong
 * @date 2019/1/8
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int start = 0, end = 0, fastest = 0;
        while (end < nums.length - 1) {
            fastest = end;
            for (int i = start; i <= end; i++) {
                if (i + nums[i] > fastest) {
                    fastest = i + nums[i];
                }
            }
            if (fastest <= end) {
                return false;
            }
            start = end + 1;
            end = fastest;
        }
        return true;
    }

    public static void  main(String[] args){
        System.out.println(canJump(new int[] {3,2,1,0,4}));
    }

}
