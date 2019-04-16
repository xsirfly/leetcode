package xsir;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/3/29
 */
public class Triangle {

    private static int MINTOTAL = Integer.MAX_VALUE;

    private static void findMin(List<List<Integer>> triangle, int level, int preIndex, int sum) {
        if (sum >= MINTOTAL) {
            return;
        }
        if (level >= triangle.size()) {
            MINTOTAL = Math.min(MINTOTAL, sum);
            return;
        }
        findMin(triangle, level + 1, preIndex, sum + triangle.get(level).get(preIndex));
        if (preIndex + 1 < triangle.get(level).size()) {
            findMin(triangle, level + 1, preIndex + 1, sum + triangle.get(level).get(preIndex + 1));
        }
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        findMin(triangle, 0, 0, 0);
        return MINTOTAL;
    }

    public static void  main(String[] args){
//        System.out.println(minimumTotal(Arrays.asList(
//            Arrays.asList(2),
//            Arrays.asList(3, 4),
//            Arrays.asList(6, 5, 7),
//            Arrays.asList(4, 1, 8, 3)
//        )));

        System.out.println(minimumTotal(Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2, 3)
        )));
    }

}
