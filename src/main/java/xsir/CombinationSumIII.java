package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            find(k, n, 1, i, i, res, Collections.singletonList(i));
        }
        return res;
    }

    private static void find(int k, int n, int times, int sum, int i, List<List<Integer>> res, List<Integer> tmp) {
        if (times == k) {
            if (sum == n) {
                res.add(tmp);
            }
            return;
        }
        if (sum > n) {
            return;
        }
        for (int idx = i + 1; idx < 10; idx++) {
            List<Integer> newTmp = new ArrayList<>(tmp);
            newTmp.add(idx);
            find(k, n, times + 1, sum + idx, idx, res, newTmp);
        }
    }

    public static void main(String[] args) {
//        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }
}
