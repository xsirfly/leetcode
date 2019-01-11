package xsir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/1/10
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        List<Integer> candidate = new ArrayList<>();
        int div;
        for (int i = 0; i < n; i++) {
            candidate.add(i + 1);
        }
        for (int i = 0; i < n; i++) {
            int factorial = factorial(n - i - 1);
            if (n - i - 1 == 0) {
                div = 0;
            } else {
                div = (k - 1) / factorial;
            }
            res.append(candidate.get(div));
            candidate.remove(div);
            k = k - div * factorial;
        }
        return res.toString();
    }

    public static int factorial(int i) {
        int res = 1;
        for (int i1 = 1; i1 <= i; i1++) {
            res *= i1;
        }
        return res;
    }

    public static void  main(String[] args){
        System.out.println(getPermutation(3, 3));
    }

}
