package xsir;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangcong
 * @date 2018/10/17
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", 0, n);
        return result;
    }

    private void generateParenthesis(List<String> result, String str,
        int remainr, int remainl) {
        if (remainl == 0 && remainr == 0) {
            result.add(str);
            return;
        }
        if (remainl > 0) {
            generateParenthesis(result, str + "(", remainr+1, remainl-1);
        }
        if (remainr > 0) {
            generateParenthesis(result, str + ")", remainr-1, remainl);
        }
    }

}
