package xsir;

import java.util.*;

public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        Set<String> mem = new HashSet<>();
        boolean found = false;
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (isVaild(cur)) {
                result.add(cur);
                found = true;
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                    String next = cur.substring(0, i) + cur.substring(i + 1);
                    if (!mem.contains(next)) {
                        q.add(next);
                        mem.add(next);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isVaild(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }

        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()"));
    }
}
