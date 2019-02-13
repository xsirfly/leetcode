package xsir;

public class Sqrt {

    public static int mySqrt(int x) {
        int i = 1;
        double res = 1;
        while (res < x) {
            i  = i << 1;
            res = i * (double)i;
        }
        if (res == x) return i;
        int start = i >> 1, end = i, mid = 0;
        while (end > start) {
            mid = (start + end) >> 1;
            if (mid == start) {
                start++;
                continue;
            }
            res = mid * (double)mid;
            if (res > x) end = mid;
            else if (res < x) start = mid;
            else return mid;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }

}
