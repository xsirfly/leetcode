package xsir;

/**
 * @author zhangcong
 * @date 2019/1/9
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int res = 0, cur = s.length() - 1;
        while (cur >= 0 && s.charAt(cur) == ' ') {
            cur--;
        }
        while (cur >= 0 && s.charAt(cur--) != ' ') {
            res++;
        }
        return res;
    }

    public static void  main(String[] args){
        System.out.println(lengthOfLastWord("   "));
    }

}
