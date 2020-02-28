package xsir;

public class GameofLife {
    public void gameOfLife(int[][] board) {
        int liveNeighbors = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                liveNeighbors = getLiveNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2) {
                        board[i][j] = 2;
                    } else if (liveNeighbors > 3) {
                        board[i][j] = 2;
                    }
                } else if (board[i][j] == 0) {
                    if (liveNeighbors == 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (board[i][j] == 2) {
                   board[i][j] = 0;
               } else if (board[i][j] == -1) {
                   board[i][j] = 1;
               }
            }
        }
    }

    private int getLiveNeighbors(int[][] board, int r, int c) {
        int lives = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int curr, curc;
        for (int[] direction : directions) {
            curr = r + direction[0];
            curc = c + direction[1];
            if (curr >= 0 && curr < board.length
                    && curc >= 0 && curc < board[0].length
                    && board[curr][curc] > 0) {
                lives++;
            }
        }
        return lives;
    }
}
