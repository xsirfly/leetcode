package xsir;

/**
 * @author zhangcong
 * @date 2019/1/14
 */
public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] mem = new int[rows][cols];
        int min;
        boolean hasSetMin;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                min = Integer.MAX_VALUE;
                hasSetMin = false;
                if (i - 1 >= 0) {
                    min = mem[i - 1][j];
                    hasSetMin = true;
                }
                if (j - 1 >= 0 && mem[i][j - 1] < min) {
                    min = mem[i][j - 1];
                    hasSetMin = true;
                }
                if (!hasSetMin) {
                    min = 0;
                }
                mem[i][j] = grid[i][j] + min;
            }
        }
        return mem[rows - 1][cols - 1];
    }

    public static void  main(String[] args){
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

}
