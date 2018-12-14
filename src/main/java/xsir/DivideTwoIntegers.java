package xsir;

/**
 * @author zhangcong
 * @date 2018/12/14
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        boolean flag = dividend < 0 == divisor < 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        int currentDivisor = divisor, res = 0, step = -1, diff = dividend;
        // find suitable step
        while ((diff <= currentDivisor << 1) && (currentDivisor >= Integer.MIN_VALUE >> 1)) {
            currentDivisor = currentDivisor << 1;
            step = step << 1;
        }
        while (diff <= divisor) {
            diff = diff - currentDivisor;
            res += step;
            if (diff > divisor) {
                break;
            }
            while (diff > currentDivisor && step < -1) {
                currentDivisor = currentDivisor >> 1;
                step = step >> 1;
            }
        }
        if (flag && res == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return flag ? -res : res;
    }

    public static void  main(String[] args){
        DivideTwoIntegers div = new DivideTwoIntegers();
        System.out.println(div.divide(-2147483648, 1));
    }

}
