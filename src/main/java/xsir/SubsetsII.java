package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/4/16
 */
public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        List<Integer> tmpRes = new ArrayList<>();
        Arrays.sort(nums);
        genSub(nums, 0, false, tmpRes, res);
        return res;
    }

    private static void genSub(int[] nums, int curIndex, boolean putted, List<Integer> tmpRes, List<List<Integer>> res) {
        if (curIndex >= nums.length) {
            res.add(tmpRes);
            return;
        }
        genSub(nums, curIndex + 1, false, tmpRes, res);
        if (curIndex == 0 || nums[curIndex] != nums[curIndex - 1] || putted) {
            List<Integer> newTmp = new ArrayList<>(tmpRes);
            newTmp.add(nums[curIndex]);
            genSub(nums, curIndex + 1, true, newTmp, res);
        }
    }

    public static void  main(String[] args){
        List<List<Integer>> res = subsetsWithDup(new int[]{4, 4, 4, 1, 4});
        System.out.println(res);
    }

}
