package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/1/7
 */
public class NQueen {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] aBoard : board) {
            Arrays.fill(aBoard, '.');
        }
        solve(n, 0, board, result);
        return result;
    }

    public static void solve(int n, int row, char[][] board, List<List<String>> result) {
        if (row >= n) {
            List<String> tmpRes = new ArrayList<>();
            for (char[] aBoard : board) {
                tmpRes.add(new String(aBoard));
            }
            result.add(tmpRes);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isAllow(board, row, i)) {
                board[row][i] = 'Q';
                solve(n, row + 1, board, result);
                board[row][i] = '.';
            }
        }
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
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }
}
