package xsir;

import java.util.*;

public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        Arrays.sort(candidates);
        combination(candidates, results, Collections.EMPTY_LIST, target, 0);
        return results;
    }

    public static void combination(int[] candidates, List<List<Integer>> results, List<Integer> result, int target, int cur) {
        if (target == 0) {
            results.add(result);
            return;
        } else if (target < 0 || cur == candidates.length) {
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (i == cur || candidates[i] != candidates[i - 1]) {
                List<Integer> tmp = new ArrayList<>(result);
                tmp.add(candidates[i]);
                combination(candidates, results, tmp, target - candidates[i], i + 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(results);
    }
}
