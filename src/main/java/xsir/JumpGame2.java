package xsir;

/**
 * @author zhangcong
 * @date 2018/12/28
 */
public class JumpGame2 {

    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < nums.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (nums[i] + i > farthest) {
                    farthest = nums[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        return jumps;
    }

    public static void  main(String[] args){
        long start = System.currentTimeMillis();
//        8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5
//        [5,9,3,2,1,0,2,3,3,1,0,0]
        int res = jump(new int[] {2,3,1,1,4});
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);
    }

}
