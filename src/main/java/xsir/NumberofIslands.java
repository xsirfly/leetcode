package xsir;

public class NumberofIslands {
    public static int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        boolean[][] mem = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!mem[i][j] && grid[i][j] == '1') {
                    res++;
                    fire(grid, i, j, mem);
                }
            }
        }
        return res;
    }

    private static void fire(char[][] grid, int i, int j, boolean[][] mem) {
        if (grid[i][j] == '0') {
            mem[i][j] = true;
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            mem[i][j] = true;
        }
        if (i - 1 >= 0 && !mem[i - 1][j]) {
            fire(grid, i - 1, j, mem);
        }
        if (i + 1 < grid.length && !mem[i + 1][j]) {
            fire(grid, i + 1, j, mem);
        }
        if (j - 1 >= 0 && !mem[i][j - 1]) {
            fire(grid, i, j - 1, mem);
        }
        if (j + 1 < grid[0].length && !mem[i][j + 1]) {
            fire(grid, i, j + 1, mem);
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        }));
    }


}
