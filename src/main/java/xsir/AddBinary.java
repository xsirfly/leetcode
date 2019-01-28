package xsir;

/**
 * @author zhangcong
 * @date 2019/1/14
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int mod = 0, addon = 0, sum = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            sum = 0;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            mod = (sum + addon) % 2;
            addon = (sum + addon) / 2;
            result.append(String.valueOf(mod));
            i--; j--;
        }
        if (addon != 0) {
            result.append(String.valueOf(addon));
        }
        return result.reverse().toString();
    }

    public static void  main(String[] args){
        System.out.println(addBinary("11", "10"));
    }



}
