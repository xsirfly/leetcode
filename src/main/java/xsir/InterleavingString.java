package xsir;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2.length() == 0) {
            return s1.equals(s3);
        }
        boolean[][] mem = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            mem[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 0; i <= s2.length(); i++) {
            mem[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++ ) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && mem[i - 1][j]) {
                    mem[i][j] = true;
                }
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && mem[i][j - 1]) {
                    mem[i][j] = true;
                }
            }
        }
        return mem[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
