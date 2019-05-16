package xsir;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }
        int[][] mem = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            mem[0][i] = i;
        }
        for (int i = 0; i <= word1.length(); i++) {
            mem[i][0] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    mem[i][j] = mem[i - 1][j - 1];
                } else {
                    int add = mem[i][j - 1] + 1;
                    int delete = mem[i - 1][j] + 1;
                    int update = mem[i - 1][j - 1] + 1;
                    mem[i][j] = Math.min(add, Math.min(delete, update));
                }
            }
        }
        return mem[word1.length()][word2.length()];
    }
    
    public static void main(String[] args) {
        System.out.println(minDistance("a", "ab"));
    }
}
