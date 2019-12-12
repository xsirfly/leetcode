package xsir;

public class CountPrimes {
    public static  int countPrimes(int n) {
        int res = 0;
        if (n <= 1) {
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            if (isPrimes(i)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isPrimes(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(2));
    }
}
