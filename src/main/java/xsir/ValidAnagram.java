package xsir;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            dict.compute(s.charAt(i), (key, oldValue) -> oldValue == null ? 1 : ++oldValue);
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (!dict.containsKey(c)) {
                return false;
            }
            int num = dict.get(c);
            if (num <= 0) {
                return false;
            }
            dict.put(c, num - 1);
        }
        return dict.entrySet().stream().noneMatch(e -> e.getValue() != 0);
    }
}
