package xsir;

public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        long start = 1, end = n;
        while(start < end) {
            long mid = (start + end) >> 1;
            if (isBadVersion((int)mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (int)start;
    }

    private static boolean isBadVersion(int a) {
        return a >= 1702766719;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
}
