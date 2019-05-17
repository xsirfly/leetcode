package xsir;

public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        int[][] mem = new int[s.length()][t.length()];
        mem[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            mem[i][0] = s.charAt(i) == t.charAt(0) ? mem[i - 1][0] + 1 : mem[i - 1][0];
        }
        for (int i = 1; i < t.length(); i++) {
            mem[0][i] = 0;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (j > i) {
                    mem[i][j] = 0;
                } else if (s.charAt(i) == t.charAt(j)) {
                    mem[i][j] = mem[i - 1][j - 1] + mem[i - 1][j];
                } else {
                    mem[i][j] = mem[i - 1][j];
                }
            }
        }
        return mem[s.length() - 1][t.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }
}
