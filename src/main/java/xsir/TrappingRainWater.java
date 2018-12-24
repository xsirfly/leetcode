package xsir;

/**
 * @author zhangcong
 * @date 2018/12/24
 */
public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int result = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > maxLeft[i - 1]) {
                maxLeft[i] = height[i - 1];
            } else {
                maxLeft[i] = maxLeft[i - 1];
            }
        }
        for (int i = height.length - 2; i >=0; i--) {
            if (height[i + 1] > maxRight[i + 1]) {
                maxRight[i] = height[i + 1];
            } else {
                maxRight[i] = maxRight[i + 1];
            }
        }
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= Math.min(maxLeft[i], maxRight[i])) {
                continue;
            }
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
    }
    
    public static void  main(String[] args){
        int res = trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(res);
    }

}
