package xsir;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhangcong
 * @date 2018/12/19
 */
public class LongestValidParentheses {

    public static class Entry {
        private Character key;
        private Integer value;

        public Entry(Character key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Character getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static int longestValidParentheses(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int max = 0, pre = -1;
        Stack<Entry> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(new Entry(s.charAt(i), i));
            } else if (')' == s.charAt(i)) {
                if (!stack.isEmpty() && '(' == stack.peek().getKey()) {
                    stack.pop();
                } else {
                    stack.push(new Entry(s.charAt(i), i));
                }
            }
        }
        if (stack.isEmpty()) {
            return s.length();
        }

        for (int i = 0; i < stack.size(); i++) {
            Entry entry = stack.get(i);
            if ((entry.getValue() - pre - 1) > max) {
                max = entry.getValue() - pre - 1;
            }
            if ((i == stack.size() - 1) && (s.length() - entry.getValue() - 1) > max) {
                max = s.length() - entry.getValue() - 1;
            }
            pre = entry.getValue();
        }
        return max;
    }
    
    public static void  main(String[] args){
        int res = longestValidParentheses("(()()(");
        System.out.println(res);
    }

}
