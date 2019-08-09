package xsir;

public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix == null || matrix.length == 0) {
            return maxArea;
        }
        int c = 0, colMin;
        int[][] mem = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            c = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    c++;
                } else {
                    c = 0;
                }
                mem[i][j] = c;
                colMin = mem[i][j];
                for (int k = i; k >= 0; k--) {
                    colMin = Math.min(colMin, mem[k][j]);
                    maxArea = Math.max(maxArea, colMin * (i - k + 1));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }

}
