package xsir;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<String, Character> dict = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (dict.containsKey(words[i])) {
                sb.append(dict.get(words[i]));
            } else if (dict.containsValue(pattern.charAt(i))){
                return false;
            } else {
                sb.append(pattern.charAt(i));
                dict.put(words[i], pattern.charAt(i));
            }
        }
        return sb.toString().equals(pattern);
    }
}
