package xsir;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangcong
 * @date 2019/1/2
 */
public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        permute(nums, Collections.emptyList(), result);
        return new ArrayList<>(result);
    }

    public static void permute(int[] nums, List<Integer> ser, Set<List<Integer>> result) {
        if (ser.size() == nums.length) {
            result.add(ser);
            return;
        }
        for (int num : nums) {
            if (!ser.contains(num)) {
                List<Integer> tmp = new ArrayList<>(ser);
                tmp.add(num);
                permute(nums, tmp, result);
            }
        }
    }

    public static void  main(String[] args){
        List<List<Integer>> res = permuteUnique(new int[] {1, 1, 2});
        System.out.println(res);
    }

}
