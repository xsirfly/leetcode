package xsir;

/**
 * @author zhangcong
 * @date 2018/12/24
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int numi1, numi2, addon = 0;
        String s, l;
        if (num1.length() > num2.length()) {
            s = num2;
            l = num1;
        } else {
            s = num1;
            l = num2;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            numi1 = Integer.parseInt(s.substring(i, i + 1));
            StringBuilder tmp = new StringBuilder();
            for (int j = l.length() - 1; j >= 0; j--) {
                numi2 = Integer.parseInt(l.substring(j, j + 1));
                int tmpi = numi1 * numi2 + addon;
                tmp.append(tmpi % 10);
                addon = tmpi / 10;
            }
            if (addon != 0) {
                tmp.append(String.valueOf(addon));
                addon = 0;
            }
            tmp = tmp.reverse();
            for (int j = 0; j < s.length() - i - 1; j++) {
                tmp.append("0");
            }
            result = add(result.toString(), tmp.toString());
        }
        int i = 0;
        while (i < result.length() - 1 && result.charAt(i) == '0') {
            i++;
        }
        return result.toString().substring(i, result.length());
    }

    public static StringBuilder add(String num1, String num2) {
        if (num1.isEmpty()) {
            return new StringBuilder(num2);
        }
        if (num2.isEmpty()) {
            return new StringBuilder(num1);
        }
        int numi1, numi2, addon = 0, tmp;
        int len = Math.max(num1.length(), num2.length());
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            numi1 = i < 0 ? 0 : Integer.parseInt(num1.substring(i, i + 1));
            numi2 = j < 0 ? 0 : Integer.parseInt(num2.substring(j, j + 1));
            tmp = (numi1 + numi2 + addon) % 10;
            addon = (numi1 + numi2 + addon) / 10;
            result.append(String.valueOf(tmp));
            i--;
            j--;
        }
        if (addon != 0) {
            result.append(String.valueOf(addon));
        }

        return result.reverse();
    }

    public static void  main(String[] args){
        String res = multiply("99", "0");
        System.out.println(res);
    }
}
