package xsir;

public class AddDigits {
    public int addDigits(int num) {
        while (num >= 10) {
            int div = num / 10;
            int mod = num % 10;
            num = div + mod;
        }
        return num;
    }
}
