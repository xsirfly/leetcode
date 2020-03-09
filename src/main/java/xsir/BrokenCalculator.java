package xsir;

public class BrokenCalculator {
    public static int brokenCalc(int X, int Y) {
        int cur = Y, target = X, res = 0;
        while (cur != target) {
            if (cur > target * 2) {
                cur = cur % 2 == 0 ? cur / 2 : cur + 1;
            } else if (cur < target) {
                cur++;
            } else {
                if (cur % 2 != 0) {
                    cur++;
                } else {
                    int m = (target - cur / 2) + 1;
                    int n = (target * 2 - cur) + 1;
                    res += Math.min(m, n);
                    break;
                }
            }
            res++;
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(brokenCalc(5, 8));
        System.out.println(brokenCalc(3, 10));
        System.out.println(brokenCalc(1024, 1));
        System.out.println(brokenCalc(1, 1000000000));
    }

}
