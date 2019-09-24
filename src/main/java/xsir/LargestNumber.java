package xsir;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        if (nums.length > 1 && Arrays.stream(nums).sum() == 0) {
            return "0";
        }
        return Arrays.stream(nums).mapToObj(Integer::toString)
                .sorted((n1, n2) -> (n2 + n1).compareTo(n1 + n2)).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{9847, 984}));
    }
}
