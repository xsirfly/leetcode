package xsir;

import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {

    private int[] ielements = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    private String[] selements = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    private Map<String, Integer> r2i = new HashMap<String, Integer>() {
        {
            for (int i = 0; i < selements.length; i++) {
               put(selements[i], ielements[i]);
            }
        }
    };

    public int romanToInt(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int cur = 0, next = 1, result = 0, step;
        String element = "";
        while (cur < s.length()) {
            if (next < s.length() && r2i.get(s.substring(cur, next + 1)) != null) {
                element = s.substring(cur, next + 1);
                step = 2;
            } else {
                element = s.substring(cur, next);
                step = 1;
            }
            if (r2i.get(element) != null) {
                result += r2i.get(element);
            }
            cur += step;
            next += step;
        }
        return result;
    }
}
