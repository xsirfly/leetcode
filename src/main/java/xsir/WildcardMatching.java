package xsir;

/**
 * @author zhangcong
 * @date 2018/12/25
 */
public class WildcardMatching {


    public static boolean isMatch(String s, String p) {
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] mem = new boolean[s.length()][p.length()];
        return isMatch(s, p, 0, 0, visited, mem);
    }

    public static boolean isMatch(String s, String p, int si, int pi, boolean[][] visited, boolean[][] mem) {
        System.out.println(si + " " + pi);
        if (si == s.length() && pi == p.length()) {
            return true;
        }
        if (pi == p.length()) {
            return false;
        }
        if (si == s.length()) {
            return isAllStar(p, pi);
        }
        if (visited[si][pi]) {
            System.out.println(si + " " + pi + "is matched");
            return mem[si][pi];
        }

        boolean matched = false;
        if (p.charAt(pi) == '*') {
            matched = isMatch(s, p, si, pi + 1, visited, mem) || isMatch(s, p, si + 1, pi, visited, mem);
        } else if (si < s.length() && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')) {
            matched = isMatch(s, p, si + 1, pi + 1, visited, mem);
        }
        visited[si][pi] = true;
        mem[si][pi] = matched;
        return matched;
    }

    public static boolean isAllStar(String p, int pi) {
        while (pi < p.length()) {
            if (p.charAt(pi) != '*') {
                return false;
            }
            pi++;
        }
        return true;
    }
    
    public static void  main(String[] args){
        long start = System.currentTimeMillis();
//        "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
//        "a*******b"

//        "bbbababbbbabbbbababbaaabbaababbbaabbbaaaabbbaaaabb"
//        "*b********bb*b*bbbbb*ba"

//        "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
//        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"

//        "bbbab"
//        "*??a?"

//        "c"
//        "*?*"

//        ""
//        "*"

//        "adceb"
//        "*a*b"
        boolean res = isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",  "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb");
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);
    }

}
