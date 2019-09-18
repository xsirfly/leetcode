package xsir;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
