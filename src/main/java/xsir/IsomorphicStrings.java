package xsir;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> dict = new HashMap<>();
        Map<Character, Character> rdict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if ((dict.containsKey(s.charAt(i)) && dict.get(s.charAt(i)) != t.charAt(i))
                    || (rdict.containsKey(t.charAt(i)) && rdict.get(t.charAt(i)) != s.charAt(i))) {
                return false;
            }
            dict.put(s.charAt(i), t.charAt(i));
            rdict.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
