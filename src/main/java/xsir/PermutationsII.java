package xsir;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, 0, Collections.emptyList(), result);
        return result;
    }

    public static void permute(int[] nums, int index, List<Integer> ser, List<List<Integer>> result) {
        if (ser.size() == nums.length) {
            result.add(ser);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>(ser);
            tmp.add(nums[i]);
            swap(nums, index, i);
            permute(nums, index + 1, tmp, result);
            rswap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        for (int a = j - 1; a >= i; a--) {
            nums[a + 1] = nums[a];
        }
        nums[i] = tmp;
    }

    public static void rswap(int[] nums, int i, int j) {
        int tmp = nums[i];
        for (int a = i; a < j; a++) {
            nums[a] = nums[a + 1];
        }
        nums[j] = tmp;
    }

    public static void  main(String[] args) {
//        0,1,0,0,9
        List<List<Integer>> res = permuteUnique(new int[] {0,1,0,0,9});
        System.out.println(res);
    }

}
