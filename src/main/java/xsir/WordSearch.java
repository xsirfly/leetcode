package xsir;

/**
 * @author zhangcong
 * @date 2019/3/27
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] mem = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    mem[i][j] = true;
                    if (!findWord(board, mem, i, j, 1, word)) {
                        mem[i][j] = false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean findWord(char[][] board, boolean[][] mem, int i, int j, int curIndex, String word) {
        if (curIndex == word.length()) {
            return true;
        }
        return testNextStep(board, mem, i - 1, j, curIndex, word)
            || testNextStep(board, mem, i + 1, j, curIndex, word)
            || testNextStep(board, mem, i, j - 1, curIndex, word)
            || testNextStep(board, mem, i, j + 1, curIndex, word);
    }

    private static boolean testNextStep(char[][] board, boolean[][] mem, int i, int j, int curIndex, String word) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return false;
        }
        if (!mem[i][j] && board[i][j] == word.charAt(curIndex)) {
            mem[i][j] = true;
            if (!findWord(board, mem, i, j,  curIndex + 1, word)) {
                mem[i][j] = false;
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void  main(String[] args){
        System.out.println(exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }, "ABCB"));
    }

}
