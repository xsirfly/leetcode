package xsir;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Roman2IntegerTest {
    private Roman2Integer roman2Integer;

    @Before
    public void init() {
        roman2Integer = new Roman2Integer();
    }

    @Test
    public void test() {
        int[] nums = {3, 4, 9, 58, 1994};
        String[] results = {"III", "IV", "IX", "LVIII", "MCMXCIV"};

        for (int i = 0; i < results.length; i++) {
            int result = roman2Integer.romanToInt(results[i]);
            System.out.println(results[i] + "->" + result);
            Assert.assertEquals(nums[i], result);
        }
    }
}
