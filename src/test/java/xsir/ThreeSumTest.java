package xsir;

import org.junit.Test;

import java.util.List;

public class ThreeSumTest {

    private ThreeSum threeSum = new ThreeSum();


    @Test
    public void test() {
        int[] arr = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println((-4 ^ 6));
        System.out.println((-2 ^ 4));
        List<List<Integer>> result = threeSum.threeSum(arr);
        System.out.println(result);
    }
}
