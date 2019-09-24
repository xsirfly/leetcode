package xsir;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int mem[][] = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                mem[i][j] = Integer.MAX_VALUE;
            }
        }
        mem[m][n - 1] = 1; mem[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                mem[i][j] = Math.max(Math.min(mem[i + 1][j], mem[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return mem[0][0];
    }

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][] {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        }));

        System.out.println(calculateMinimumHP(new int[][]{
                {3,-20,30},
                {-3,4,0}
        }));

        System.out.println(calculateMinimumHP(new int[][]{
                {1,-3,3},
                {0,-2,0},
                {-3,-3,-3},
        }));
    }
}
