package xsir;

import java.util.*;

public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null) {
            return Collections.emptyList();
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
        if (!mem[s.length() - 1]) {
            return Collections.EMPTY_LIST;
        }
        List<String> res = new ArrayList<>();
        find(s, 0, mem, dict, "", res);
        return res;
    }

    private List<String> find(String s, int start, boolean[] mem, Set<String> dict, String mid, List<String> res) {
        if (start >= s.length()) {
            res.add(mid);
            return res;
        }
        for (int i = start; i < s.length(); i++) {
            if (mem[i] && dict.contains(s.substring(start, i + 1))) {
                String tmp = mid.isEmpty() ? s.substring(start, i + 1) : mid + " " + s.substring(start, i + 1);
                find(s, i + 1, mem, dict, tmp, res);
            }
        }
        return res;
    }
}
