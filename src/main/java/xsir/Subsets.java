package xsir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/3/27
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        for (int i = 0; i <= nums.length; i++) {
            List<List<Integer>> iSubSets = new ArrayList<>();
            genSubSetsByN(nums, 0, i, i, new ArrayList<>(), iSubSets);
            result.addAll(iSubSets);
        }
        return result;
    }

    private static void genSubSetsByN(int[] nums, int curIndex, int n, int curK, List<Integer> tmpSubSet, List<List<Integer>> subsets) {
        if (n == 0 || curK == 0) {
            subsets.add(tmpSubSet);
            return;
        }
        for (int i = curIndex; i < nums.length; i++) {
            List<Integer> newTmpSubSet = new ArrayList<>(tmpSubSet);
            newTmpSubSet.add(nums[i]);
            genSubSetsByN(nums, i + 1, n, curK - 1, newTmpSubSet, subsets);
        }
    }

    public static void  main(String[] args){
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
