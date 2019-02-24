package xsir;

import java.util.Arrays;
import java.util.stream.Stream;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        boolean[][] mems = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!mems[i][j]) setZero(matrix, mems, i, j);
            }
        }
    }

    private static void setZero(int[][] matrix, boolean[][] mems, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return;
        }

        if (matrix[i][j] == 0) {
            for (int k = 0; k < matrix[0].length; k++) {
                if (matrix[i][k] != 0) {
                    matrix[i][k] = 0;
                    mems[i][k] = true;
                }
            }

            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][j] != 0) {
                    matrix[k][j] = 0;
                    mems[k][j] = true;
                }
            }
        }
        mems[i][j] = true;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(arr);
        Stream.of(arr).forEach(a -> System.out.println(Arrays.toString(a)));
    }

}
