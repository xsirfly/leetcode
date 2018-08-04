package xsir;

import org.junit.Test;

import java.util.Arrays;

public class SortColorsTest {

    private SortColors sortColors = new SortColors();

    @Test
    public void test() {
        int[] nums = {2, 0, 1};
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
