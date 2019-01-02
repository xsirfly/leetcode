package xsir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/1/2
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, Collections.emptyList(), result);
        return result;
    }

    public static void permute(int[] nums, List<Integer> ser, List<List<Integer>> result) {
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
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
        System.out.println(res);
    }

}
