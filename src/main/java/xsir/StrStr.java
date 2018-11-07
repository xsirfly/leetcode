package xsir;

import com.sun.java.swing.action.NextAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangcong
 * @date 2018/11/7
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }

    public int kmp(String str, String pattern) {
        if ("".equals(pattern)) {
            return 0;
        }
        if (pattern.length() > str.length()) {
            return -1;
        }
        int[] next = next(pattern);
        int i = 0, j = 0;
        while (i < str.length() && j < pattern.length()) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return i - j;
                }
            } else if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
        }
        return -1;
    }

    public int[] next(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        int k = -1;
        int len = pattern.length();
        next[0] = -1;

        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {

                j++;
                k++;
                next[j] = k;
            } else {

                // 比较到第K个字符，说明p[0——k-1]字符串和p[j-k——j-1]字符串相等，而next[k]表示
                // p[0——k-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[k]]和p[j]
                k = next[k];
            }
        }
        return next;
    }

}
