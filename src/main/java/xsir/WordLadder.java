package xsir;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || beginWord == null || endWord == null) {
            return 0;
        }
        boolean[] mem = new boolean[wordList.size()];
        int min = 0;
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            min++;
            for (int j = 0; j < size; j++) {
                String str = q.poll();
                if (str.equals(endWord)) {
                    return min;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (!mem[i] && diffOne(str, wordList.get(i))) {
                        q.add(wordList.get(i));
                        mem[i] = true;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean diffOne(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList( "si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"
        );
        int min = ladderLength("qa", "sq", wordList);

        System.out.println(min);
    }
}
