package xsir;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int div = n, mod = 0;
        while (div != 0) {
            mod = div % 26;
            if (mod == 0) {
                sb.append('Z');
                div = div / 26 - 1;
            } else {
                sb.append((char)(mod - 1 + 'A'));
                div = div / 26;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
