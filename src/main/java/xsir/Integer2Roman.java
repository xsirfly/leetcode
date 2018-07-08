package xsir;

import java.util.HashMap;
import java.util.Map;

public class Integer2Roman {

    public static int[] ielements = {1, 5, 10, 50, 100, 500, 1000};

    public static int[] specialIElements = {4, 9, 40, 90, 400, 900};

    public static String[] celements = {"I", "V", "X", "L", "C", "D", "M"};

    public static Map<Integer, String> i2r = new HashMap<Integer, String>() {
        {
            for (int i = 0; i < ielements.length; i++) {
                put(ielements[i], celements[i]);
            }
        }
    };

    public static Map<Integer, String> specialI2r = new HashMap<Integer, String>() {
        {
            put(4, "IV");
            put(9, "IX");
            put(40, "XL");
            put(90, "XC");
            put(400, "CD");
            put(900, "CM");
        }
    };

    public static int findMax(int num) {
        int pre = -1, current = 0;
        while (current < ielements.length) {
            if ((pre < 0 || ielements[pre] <= num) && ielements[current] > num) {
                return ielements[pre];
            }
            pre++;
            current++;
        }
        return ielements[ielements.length - 1];
    }

    public static void fill(StringBuilder sb, String element, int times) {
        if (sb == null || times <= 0) {
            return;
        }
        for (int i = 0; i < times; i++) {
            sb.append(element);
        }
    }

    public static int getSpecialElement(int num) {
        int pre = -1, current = 0, index = specialIElements.length -1;
        while (current < specialIElements.length) {
            if ((pre < 0 || specialIElements[pre] <= num) && specialIElements[current] > num) {
                index = pre;
                break;
            }
            pre++;
            current++;
        }
        if (index >= 0 && num >= specialIElements[index] && num < ielements[index + 1]) {
            return specialIElements[index];
        }
        return -1;
    }

    public String intToRoman(int num) {
        if (num <= 0) {
            return null;
        }
        int div, current = num;
        StringBuilder sb = new StringBuilder();
        int specialElement;
        while (current != 0) {
            specialElement = getSpecialElement(current);
            if (specialElement != -1) {
                sb.append(specialI2r.get(specialElement));
                current -= specialElement;
                continue;
            }
            div = findMax(current);
            fill(sb, i2r.get(div), current / div);
            current = current % div;
        }

        return sb.toString();
    }
}
