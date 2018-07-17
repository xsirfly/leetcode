package xsir;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonPrefixTest {

    private LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();


    @Test
    public void test1() {
        String result = longestCommonPrefix.longestCommonPrefix(new String[] {"aaa","aa","aaa"});
        Assert.assertEquals("aa", result);
    }

    @Test
    public void test2() {
        String result = longestCommonPrefix.longestCommonPrefix(new String[] {"dog","racecar","car"});
        Assert.assertEquals("", result);
    }
}
