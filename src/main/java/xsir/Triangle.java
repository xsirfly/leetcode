package xsir;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/3/29
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int[] lastMem = new int[triangle.size()];
        int[] mem = new int[triangle.size()];
        lastMem[0] = triangle.get(0).get(0);
        int min = lastMem[0];
        for (int i = 1; i < triangle.size(); i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    mem[j] = triangle.get(i).get(j) + lastMem[j];
                } else if (j == i) {
                    mem[j] = triangle.get(i).get(j) + lastMem[j - 1];
                } else {
                    mem[j] = Math.min(triangle.get(i).get(j) + lastMem[j], triangle.get(i).get(j) + lastMem[j - 1]);
                }
                min = Math.min(min, mem[j]);
            }
            System.arraycopy(mem, 0, lastMem, 0, mem.length);
        }
        return min;
    }

    public static void  main(String[] args){
        System.out.println(minimumTotal(Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        )));

        System.out.println(minimumTotal(Arrays.asList(
            Arrays.asList(-1),
            Arrays.asList(-2, -3)
        )));
    }

}
