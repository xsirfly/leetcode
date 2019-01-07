package xsir;

/**
 * @author zhangcong
 * @date 2019/1/4
 */
public class Pow {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        long absn = Math.abs((long)n);
        double res = 1.0D, tmpres;
        int addon, times;
        while (absn > 1) {
            times = ((int)(Math.log(absn + 1) / Math.log(2) - 2)) + 1;
            addon = 1;
            tmpres = x;
            for (int i = 0; i < times; i++) {
                tmpres = tmpres * tmpres;
                addon += addon;
            }
            res = res * tmpres;
            absn = absn - addon;
        }
        if (absn == 1) {
            res = res * x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void  main(String[] args){
        long start = System.currentTimeMillis();
//        0.00001
//        2147483647

//        2.00000
//            -2147483648
        double res = myPow(2, -2147483648);
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);
    }

}
