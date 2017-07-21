package xsir;

/**
 * Created by zhangcong on 2017/7/16.
 *
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "a*") ? true
 isMatch("aa", ".*") ? true
 isMatch("ab", ".*") ? true
 isMatch("aab", "c*a*b") ? true
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        return isMatch(s, s.length() - 1, p, p.length() - 1);
    }

    private static boolean isMatch(String s, int sEnd, String p, int pEnd) {
        if (pEnd < 0) {
            if (sEnd < 0)
                return true;
            return false;
        }
        if (p.charAt(pEnd) == '*') {
            if (pEnd - 1 < 0) {
                throw new RuntimeException("pattern is error");
            }
            if (sEnd >= 0 && (p.charAt(pEnd - 1) == '.' || p.charAt(pEnd - 1) == s.charAt(sEnd))) {
                if (isMatch(s, sEnd -1, p, pEnd))
                    return true;
            }
            return isMatch(s, sEnd, p, pEnd - 2);
        } else {
            if (sEnd >= 0 && (s.charAt(sEnd) == p.charAt(pEnd) || p.charAt(pEnd) == '.'))
                return isMatch(s, sEnd - 1, p, pEnd - 1);
            return false;
        }
    }
}
