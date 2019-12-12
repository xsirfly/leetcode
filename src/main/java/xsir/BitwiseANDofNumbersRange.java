package xsir;

public class BitwiseANDofNumbersRange {
    public static int rangeBitwiseAnd(int m, int n) {
        int start = m, end = n;
        int im = 0, in = 0;
        while (m != 0 && n != 0) {
            im++;
            in++;
            m = m >> 1;
            n = n >> 1;
        }
        if (m != 0 || n != 0 || im == 0) {
            return 0;
        }

        int flag = (int)Math.pow(2, im - 1);
        int add = flag;
        int res = 0;
        while ((start & flag) == (end & flag) && im > 0) {
            if ((start & flag) != 0) {
                res += add;
            }
            add = add >> 1;
            start = start << 1;
            end = end << 1;
            im--;
        }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(rangeBitwiseAnd(6, 6));
    }
}
