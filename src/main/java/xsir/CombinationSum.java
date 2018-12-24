package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangcong
 * @date 2018/12/21
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> middleRes = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        findCombination(candidates, 0, target, middleRes, result);
        return result;
    }

    public static void findCombination(int[] candidates, int currentIdex, int target,
        List<Integer> middleRes, List<List<Integer>> result) {
        if (target == 0) {
            result.add(middleRes);
        }
        if (target < 0) {
            return;
        }
        for (int i = currentIdex; i < candidates.length; i++) {
            List<Integer> tmp = new ArrayList<>(middleRes);
            tmp.add(candidates[i]);
            findCombination(candidates, i,target - candidates[i], tmp, result);
        }
    }
    
    public static void  main(String[] args){
        List<List<Integer>> res = combinationSum(new int[] {2,3,6,7}, 7);
        System.out.println(res);
    }

}
