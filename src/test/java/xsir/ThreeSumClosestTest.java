package xsir;

import org.junit.Test;

/**
 * @author zhangcong
 * @date 2018/10/8
 */
public class ThreeSumClosestTest {

    private ThreeSumClosest threeSumClosest = new ThreeSumClosest();

    @Test
    public void test() {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest.threeSumClosest(arr, target);
        System.out.println(result);
    }

}
