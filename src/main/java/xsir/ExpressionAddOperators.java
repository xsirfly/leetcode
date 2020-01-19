package xsir;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return result;
        }
        for (int i = 1; i < num.length(); i++) {

        }
        return null;
    }

    private static void add(String prefix, int preToken, String num, int target, List<String> res) {
        if (num == null || num.isEmpty()) {
            if (target == 0) res.add(prefix);
            return;
        }
        for (int i = 0; i < num.length(); i++) {

        }
    }



    public static void main(String[] args) {
        System.out.println(addOperators("105", 5));
    }
}
