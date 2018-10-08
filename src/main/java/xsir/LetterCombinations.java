package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangcong
 * @date 2018/10/8
 */
public class LetterCombinations {

    private Map<String, List<String>> dict = new HashMap<String, List<String>>() {
        {
            put("2", Arrays.asList("a", "b", "c"));
            put("3", Arrays.asList("d", "e", "f"));
            put("4", Arrays.asList("g", "h", "i"));
            put("5", Arrays.asList("j", "k", "l"));
            put("6", Arrays.asList("m", "n", "o"));
            put("7", Arrays.asList("p", "q", "r", "s"));
            put("8", Arrays.asList("t", "u", "v"));
            put("9", Arrays.asList("w", "x", "y", "z"));
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }
        combine(digits, 0, "", result);
        return result;
    }

    private void combine(String digits, int index, String currentStr, List<String> result) {
        if (index >= digits.length()) {
            result.add(currentStr);
            return;
        }
        List<String> elements = dict.get(String.valueOf(digits.charAt(index)));
        for (String element : elements) {
            combine(digits, index + 1, currentStr + element, result);
        }
    }
}
