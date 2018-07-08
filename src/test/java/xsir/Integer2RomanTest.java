package xsir;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Integer2RomanTest {

    private Integer2Roman integer2Roman;

    @Before
    public void init() {
        integer2Roman = new Integer2Roman();
    }

    @Test
    public void test() {
        int[] nums = {3, 4, 9, 58, 1994};
        String[] results = {"III", "IV", "IX", "LVIII", "MCMXCIV"};

        for (int i = 0; i < nums.length; i++) {
            String result = integer2Roman.intToRoman(nums[i]);
            System.out.println(nums[i] + " -> " + result);
            Assert.assertEquals(results[i], result);
        }
    }
}
