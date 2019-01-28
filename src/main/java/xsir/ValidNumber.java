package xsir;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangcong
 * @date 2019/1/28
 * failed 有限状态机解决
 */
public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        s = s.trim();
        int indexOfE = s.indexOf('e');
        if (indexOfE != -1) {
            return isDec(s.substring(0, indexOfE)) && isInt(s.substring(indexOfE + 1), -1,
                Collections.EMPTY_LIST);
        } else {
            return isDec(s);
        }
    }

    private static boolean isInt(String s, int ignoreIndex, List<Character> spe) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() == 1 && s.charAt(0) == '0') {
            return true;
        }
        if (s.charAt(0) != '+' && s.charAt(0) != '-' && !isDig(s.charAt(0), false) && !spe.contains(s.charAt(0))) {
            return false;
        }
        if ((s.charAt(0) == '+' || s.charAt(0) == '-') && s.length() == 1) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (i == ignoreIndex) {
                continue;
            }
            if (!isDig(s.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDec(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int seq = s.indexOf('.');
        if (seq != s.lastIndexOf('.')) {
            return false;
        }
        return isInt(s, seq, Arrays.asList('0', '.'));
    }

    private static boolean isDig(Character c, boolean containZero) {
        if (c == '0') {
            return containZero;
        }
        return c - '0' >= 0 && c - '0' <= 9;
    }

    public static void  main(String[] args){
        List<String> inputs = Arrays.asList(
            "0",
            " .1 ",
            "abc",
            "1 a",
            "2e10",
            " -90e3   ",
            " 1e",
            "e3",
            " 6e-1",
            " 99e2.5 ",
            "53.5e93",
            " --6 ",
            "-+3",
            "95a54e53");

        List<Boolean> results = inputs.stream().map(s -> isNumber(s)).collect(Collectors.toList());
        System.out.println(results);
    }
}
