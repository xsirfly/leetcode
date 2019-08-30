package xsir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return Collections.emptyList();
        }
        List<List<String>> res = new ArrayList<>();
        List<String> midRes = new ArrayList<>();
        partition(s, 0, midRes, res);
        return res;
    }

    private static void partition(String s, int start, List<String> mid, List<List<String>> res) {
        if (start >= s.length()) {
            res.add(mid);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                List<String> newMid = new ArrayList<>(mid);
                newMid.add(s.substring(start, i + 1));
                partition(s, i + 1, newMid, res);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = partition("abab");
        System.out.println(res);
    }
}
