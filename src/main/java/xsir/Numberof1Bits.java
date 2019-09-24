package xsir;

public class Numberof1Bits {
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(0xfffffffd));
    }
}
