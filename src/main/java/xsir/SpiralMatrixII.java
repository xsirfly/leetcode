package xsir;

import java.util.Arrays;

/**
 * @author zhangcong
 * @date 2019/1/10
 */
public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;
        for (int i = 0; i < (int)Math.ceil(n / 2d); i++) {
            for (int col = i; col < n - i; col++)  {
                res[i][col] = cur++;
            }

            for (int row = i + 1; row < n - i; row++) {
                res[row][n - i -1] = cur++;
            }

            if (i == n - i - 1) {
                continue;
            }

            for (int col = n - i - 2; col > i; col--) {
                res[n - i - 1][col] = cur++;
            }

            for (int row = n - i -1; row > i; row--) {
                res[row][i] = cur++;
            }
        }
        return res;
    }

    public static void  main(String[] args){
        int[][] res = generateMatrix(1);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

}
