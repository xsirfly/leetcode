package xsir;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> n2i = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (n2i.containsKey(nums[i])) {
                if (i - n2i.get(nums[i]) <= k) {
                    return true;
                }
            }
            n2i.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
