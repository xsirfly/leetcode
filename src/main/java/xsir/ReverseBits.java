package xsir;

/**
 * @author zhangcong
 * @date 2019/4/30
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 1; i < 32; i++) {
            res += (n & 1);
            n = n >> 1;
            res = res << 1;
        }
        res += (n & 1);
        return res;
    }
}
