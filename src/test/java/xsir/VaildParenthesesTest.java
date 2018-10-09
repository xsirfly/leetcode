package xsir;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author zhangcong
 * @date 2018/10/9
 */
public class VaildParenthesesTest {

    private ValidParentheses validParentheses = new ValidParentheses();

    @Test
    public void test() {
        System.out.println(validParentheses.isValid("()"));

    }

}
