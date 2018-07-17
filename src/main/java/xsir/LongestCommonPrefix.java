package xsir;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); i++) {
            if (!isEqual(strs, i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];

    }

    private boolean isEqual(String[] strs, int index) {
        char c = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() <= index || strs[i].charAt(index) != c ) {
                return false;
            }
        }
        return true;
    }

}
