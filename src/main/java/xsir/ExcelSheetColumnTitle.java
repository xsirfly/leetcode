package xsir;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int div = n, mod = 0;
        while (div != 0) {
            mod = (div % 27) - 1;
            div = div / 27;
            if (mod < 0) {
                sb.append('A');
            } else {
                sb.append((char)(mod - 1 + 'A'));
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println((char)(26 - 1 + 'A'));
//        System.out.println(convertToTitle(701));
    }
}
