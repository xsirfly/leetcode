package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        for (int i = 1; i <= numRows; i++) {
            Integer[] row = new Integer[i];
            row[0] = 1;
            row[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) {
                row[j] = res.get(i - 2).get(j) + res.get(i - 2).get(j - 1);
            }
            res.add(Arrays.asList(row));
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        System.out.println(res);
    }

}
