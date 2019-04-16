package xsir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/4/15
 */
public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        res.add(0);
        int tmp = 1, len;
        for (int i = 1; i <= n; i++) {
            len = res.size() - 1;
            for (int j = len; j >= 0; j--) {
                res.add(res.get(j) | tmp);
            }
            tmp = tmp << 1;
        }
        return res;
    }

    public static void  main(String[] args) {
        System.out.println(grayCode(3));
    }

}
