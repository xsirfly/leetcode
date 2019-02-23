package xsir;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Deque<String> q = new ArrayDeque<>();
        int i = 0;
        while (i < path.length()) {
            int j = i;
            while (j < path.length() && path.charAt(j) != '/') j++;
            String sub = path.substring(i, Math.min(j + 1, path.length()));
            if (sub.equals("../") || sub.equals("..")) {
                if (q.size() > 1) q.removeLast();
            } else if (sub.equals("/")) {
                if (q.isEmpty()) q.addLast(sub);
            } else if (!sub.equals("./") && !sub.equals(".")) {
                q.addLast(sub);
            }
            i = j + 1;
        }
        String res = String.join("", q);
        if (res.endsWith("/") && !res.equals("/")) res = res.substring(0, res.length() - 1);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));
    }
}
