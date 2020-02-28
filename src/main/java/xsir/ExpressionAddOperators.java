package xsir;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        op(num, target, "", 0, 0, result);
        return result;
    }

    private static void op(String num, int target, String prefix, long diff, long curNum, List<String> res) {
        if (num.isEmpty() && curNum == target) {
            res.add(prefix);
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String cur = num.substring(0, i);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                break;
            }
            String next = num.substring(i);
            long newNum = Long.valueOf(cur);
            if (prefix.length() > 0) {
                op(next, target, prefix + "+" + cur, newNum, curNum + newNum, res);
                op(next, target, prefix + "-" + cur, 0 - newNum, curNum - newNum, res);
                op(next, target, prefix + "*" + cur, diff * newNum, (curNum - diff) + (diff * newNum), res);
            } else {
                op(next, target, cur, newNum, newNum, res);
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(addOperators("105", 5));
    }
}
