package xsir;

public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == s.length()) {
            return s;
        }
        return new StringBuilder(s.substring(i)).reverse().toString() + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
    }
}
