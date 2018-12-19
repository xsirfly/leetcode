package xsir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhangcong
 * @date 2018/12/18
 */
public class SubstringConcatenation {

    public static List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Map<String, List<Integer>> word2pos = new HashMap<>();
        Map<Integer, String> pos2word = new HashMap<>();
        Map<String, Integer> flags = new HashMap<>();
        Map<String, Integer> word2times = new HashMap<>();
        int wordLen = words[0].length();
        int fromIndex, index;
        for (String word : words) {
            fromIndex = 0;
            List<Integer> indexs = new ArrayList<>();
            while ((index = s.indexOf(word, fromIndex)) != -1) {
                indexs.add(index);
                fromIndex = index + 1;
            }
            word2pos.put(word, indexs);
            word2times.compute(word, (str, old) -> old == null ? 1 : old + 1);
        }
        word2pos.forEach((key, value) -> value.forEach(pos -> pos2word.put(pos, key)));
        
        List<Integer> sortPoses = pos2word.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer pos : sortPoses) {
            if (pos > s.length() - (wordLen * words.length)) {
                break;
            }
            flags.clear();
            int curIndex = 0;
            for (int i = 0; i < words.length; i++) {
                curIndex = pos + i * wordLen;
                String word = pos2word.get(curIndex);
                if (word == null || word2times.get(word).equals(flags.get(word))) {
                    break;
                }
                flags.compute(word, (str, old) -> old == null ? 1 : old + 1);
                if (i == words.length -1) {
                    result.add(pos);
                }
            }
        }
        return result;
    }
    
    public static void  main(String[] args){
        List<Integer> res = findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","foo"});
        System.out.println(res);
    }

}
