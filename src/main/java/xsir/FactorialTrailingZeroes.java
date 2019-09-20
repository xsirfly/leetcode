package xsir;

public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n = n / 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(11));
        System.out.println(trailingZeroes(15));
        System.out.println(trailingZeroes(100));
        System.out.println(trailingZeroes(1808548329));
    }
}
