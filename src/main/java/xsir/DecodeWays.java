package xsir;

/**
 * @author zhangcong
 * @date 2019/3/27
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        int[] res = new int[s.length()];
        int[] ones = new int[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        }
        res[0] = 1;
        ones[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i - 1) == '1' && s.charAt(i) != '0') || (s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) <= '6')) {
                res[i] = res[i - 1] + ones[i - 1];
                ones[i] = res[i] - ones[i - 1];
            } else if (s.charAt(i) == '0' && s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '2'){
                res[i] = ones[i - 1];
                ones[i] = res[i] - ones[i - 1];
            } else if (s.charAt(i) != '0') {
                res[i] = res[i - 1];
                ones[i] = ones[i - 1] + res[i - 1] - ones[i - 1];
            } else {
                return 0;
            }
        }
        return res[s.length() - 1];
    }

    public static void  main(String[] args){
        System.out.println(numDecodings("24726"));
    }

}
