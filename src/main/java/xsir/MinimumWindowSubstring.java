package xsir;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> c2t = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            c2t.compute(t.charAt(i), (c, time) -> time == null ? 1 : time + 1);
        }
        int faster = 0, slow = 0, match_cnt = 0, min = Integer.MAX_VALUE, start = 0, end = 0;
        while (faster < s.length()) {
            Integer fasterCnt = c2t.computeIfPresent(s.charAt(faster), (k, v) -> v - 1);
            if (fasterCnt != null && fasterCnt == 0 && ++match_cnt == c2t.keySet().size()) {
                while (slow++ <= faster) {
                    Integer slowCnt = c2t.computeIfPresent(s.charAt(slow - 1), (k, v) -> v + 1);
                    if (slowCnt != null && slowCnt > 0) {
                        match_cnt--;
                        break;
                    }
                }
                if (faster - slow + 2 < min) {
                    min = faster - slow + 2;
                    start = slow - 1;
                    end = faster;
                }
            }
            faster++;
        }
        return min != Integer.MAX_VALUE ? s.substring(start, end + 1) : "";
    }
    
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

}
