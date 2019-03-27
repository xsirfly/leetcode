package xsir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/3/27
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        genCombination(n, 0, k, new ArrayList<>(), result);
        return result;
    }

    private static void genCombination(int n, int preN, int curK, List<Integer> combination, List<List<Integer>> combinations) {
        if (curK == 0) {
            combinations.add(combination);
            return;
        }
        for (int i = preN + 1; i <= n; i++) {
            List<Integer> newCombination = new ArrayList<>(combination);
            newCombination.add(i);
            genCombination(n, i, curK - 1, newCombination, combinations);
        }
    }

    public static void  main(String[] args){
        System.out.println(combine(4, 3));
    }



}
