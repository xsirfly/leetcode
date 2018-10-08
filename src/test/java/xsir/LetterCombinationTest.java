package xsir;

import java.util.List;
import org.junit.Test;

/**
 * @author zhangcong
 * @date 2018/10/8
 */
public class LetterCombinationTest {

    private LetterCombinations letterCombinations = new LetterCombinations();

    @Test
    public void test() {
        List<String> result = letterCombinations.letterCombinations("23");
        System.out.println(result);
    }

}
