package xsir;

import java.math.BigInteger;

/**
 * @author zhangcong
 * @date 2019/1/11
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (n == 1 || m == 1) {
            return 1;
        }
        int a = m + n - 2;
        int b = n - 1;
        double res = factorial(a) / (factorial(a - b) * factorial(b));
        return (int)Math.round(res);
    }

    public static double factorial(int i) {
        double res = 1.0D;
        for (int i1 = 1; i1 <= i; i1++) {
            res *= i1;
        }
        return res;
    }

    public static void  main(String[] args){
        System.out.println(uniquePaths(19, 13));
    }

}
