package xsir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/1/7
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < (int)Math.ceil(Math.min(rows, cols) / 2d); i++) {
            for (int c = i; c < matrix[i].length - i; c++) {
                result.add(matrix[i][c]);
            }
            for (int r = i + 1; r < rows - i; r++) {
                result.add(matrix[r][matrix[i].length - i - 1]);
            }
            if (i != rows - i -1) {
                for (int c = matrix[i].length - i - 2; c > i; c--) {
                    result.add(matrix[rows - i -1][c]);
                }
            }
            if (i != matrix[i].length - i - 1) {
                for (int r = rows - i -1; r > i; r--) {
                    result.add(matrix[r][i]);
                }
            }
        }
        return result;
    }

    public static void  main(String[] args){
        List<Integer> res = spiralOrder(new int[][]{{2, 5, 8}, {4, 0, -1}});
        System.out.println(res);
    }

}
