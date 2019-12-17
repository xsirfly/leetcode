package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        if (board == null || words == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(words).filter(word -> exist(board, word)).collect(Collectors.toList());
    }

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

    public static void main(String[] args) {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println(findWords(board, words));
    }
}
