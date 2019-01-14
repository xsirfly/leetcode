package xsir;

/**
 * @author zhangcong
 * @date 2019/1/14
 */
public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[rows - 1][cols - 1] == 1) {
            return 0;
        }
        int[][] mem = new int[rows][cols];
        mem[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) {
                    mem[i][j] += mem[i - 1][j];
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) {
                    mem[i][j] += mem[i][j - 1];
                }
            }
        }
        return mem[rows - 1][cols - 1];
    }

    public static void  main(String[] args){
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}
