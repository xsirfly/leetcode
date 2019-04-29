package xsir;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangcong
 * @date 2019/4/17
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
        return canSegmenter(s, 0, 0, new HashSet<>(wordDict));
    }

    private static boolean canSegmenter(String s, int start, int cur, Set<String> dict) {
        if (cur == s.length() - 1) {
            return dict.contains(s.substring(start, cur + 1));
        }
        if (dict.contains(s.substring(start, cur + 1))) {
            return canSegmenter(s, cur + 1, cur + 1, dict) || canSegmenter(s, start, cur + 1, dict);
        }
        return canSegmenter(s, start, cur + 1, dict);
    }

    public static void  main(String[] args){
        System.out.println(wordBreak("a", Arrays.asList("a", "pen")));
    }

}
