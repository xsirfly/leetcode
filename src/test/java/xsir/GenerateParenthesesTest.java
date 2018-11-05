package xsir;

import java.util.List;
import org.junit.Test;

/**
 * @author zhangcong
 * @date 2018/10/17
 */
public class GenerateParenthesesTest {

    private GenerateParentheses generateParentheses = new GenerateParentheses();

    @Test
    public void test() {
        List<String> result = generateParentheses.generateParenthesis(3);
        System.out.println(result);
    }

}
