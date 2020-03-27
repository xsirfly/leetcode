package xsir;

public class PowerofTwo {
    public static boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        int numOfOne = 0, flag = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & (flag << i)) > 0) {
                numOfOne++;
            }
        }
        return numOfOne == 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(isPowerOfTwo(-2147483646));
    }
}
