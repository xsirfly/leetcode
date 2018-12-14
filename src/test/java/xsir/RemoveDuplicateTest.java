package xsir;

import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicateTest {

    private RemoveDuplicates removeDuplicates = new RemoveDuplicates();

    @Test
    public void test() {
        int[] arr = {1, 2, 2};
        int len = removeDuplicates.removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(len);
    }
}
