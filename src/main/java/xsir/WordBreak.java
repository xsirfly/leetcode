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
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] mem = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    if (mem[j - 1] && dict.contains(s.substring(j, i + 1))) {
                        mem[i] = true;
                        break;
                    }
                } else {
                    if (dict.contains(s.substring(j, i + 1))) {
                        mem[i] = true;
                        break;
                    }
                }
            }
        }
        return mem[s.length() - 1];
    }

    public static void  main(String[] args){
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

}
