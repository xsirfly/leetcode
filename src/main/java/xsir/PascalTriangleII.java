package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return Collections.EMPTY_LIST;
        }
        List<List<Integer>> res = new ArrayList<>();
        int numRows = rowIndex + 1;
        for (int i = 1; i <= numRows; i++) {
            Integer[] row = new Integer[i];
            row[0] = 1;
            row[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) {
                row[j] = res.get(i - 2).get(j) + res.get(i - 2).get(j - 1);
            }
            res.add(Arrays.asList(row));
        }
        return res.get(rowIndex);
    }
}
