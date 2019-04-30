package xsir;

/**
 * @author zhangcong
 * @date 2019/4/30
 */
public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        String[] words = s.split("\\s+");
        int b = 0, e = words.length - 1;
        while (b < e) {
            String tmp = words[b];
            words[b] = words[e];
            words[e] = tmp;
            b++;
            e--;
        }
        return String.join(" ", words);
    }

    public static void  main(String[] args){
        System.out.println(reverseWords("  hello world!  "));
    }

}
