package xsir;

public class SurroundedRegions {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void dfs(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '$';
        int[][] direct = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : direct) {
            if (i + d[0] >= 0 && i + d[0] < board.length && j + d[1] >= 0 && j + d[1] < board[i].length) {
                dfs(board, i + d[0], j + d[1]);
            }
        }
    }

    public static void main(String[] args) {
        char[][] board1 = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'}
        };
        char[][] board2 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] board3 = {
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}
        };
        char[][]board4 = {
                {'X','X','X','X','X'},
                {'X','O','O','O','X'},
                {'X','X','O','O','X'},
                {'X','X','X','O','X'},
                {'X','O','X','X','X'}
        };
//        solve(board1);
//        solve(board2);
//        solve(board3);
        solve(board4);
        System.out.println(board4);
    }
}
