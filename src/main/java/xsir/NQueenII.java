package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/1/7
 */
public class NQueenII {
    public static int solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] aBoard : board) {
            Arrays.fill(aBoard, '.');
        }
        return solve(n, 0, board);
    }

    public static int solve(int n, int row, char[][] board) {
        if (row >= n) {
            return 1;
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (isAllow(board, row, i)) {
                board[row][i] = 'Q';
                total += solve(n, row + 1, board);
                board[row][i] = '.';
            }
        }
        return total;
    }

    public static boolean isAllow(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        int[][] dirs = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        int curRow, curCol;
        for (int[] dir : dirs) {
            curRow = row;
            curCol = col;
            while (curRow >= 0 && curRow < board.length
                && curCol >= 0 && curCol < board.length) {
                if (board[curRow][curCol] == 'Q') {
                    return false;
                }
                curRow += dir[0];
                curCol += dir[1];
            }
        }
        return true;
    }

    public static void  main(String[] args){
        int result = solveNQueens(4);
        System.out.println(result);
    }
}
