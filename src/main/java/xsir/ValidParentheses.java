package xsir;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhangcong
 * @date 2018/10/9
 */
public class ValidParentheses {

    private Map<Character, Character> cmap = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    public boolean isValid(String s) {
        Stack<Character> cs = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (cmap.containsValue(s.charAt(i))) {
                cs.push(s.charAt(i));
            } else if (cs.isEmpty() || !cmap.get(s.charAt(i)).equals(cs.pop())) {
                return false;
            }
        }
        return cs.isEmpty();
    }

}
