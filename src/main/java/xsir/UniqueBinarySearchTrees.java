package xsir;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangcong
 * @date 2019/3/29
 */
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        long start = System.currentTimeMillis();
        int preNum = 1;
        int[] highs = new int[1];
        highs[0] = 1;
        int curNum = preNum;
        for (int i = 2; i <= n; i++) {
            curNum = preNum;
            int[] curHighs = new int[highs.length + 1];
            for (int j = 0; j < highs.length; j++) {
                curNum += (j + 1) * highs[j];
            }
            for (int j = 0; j < curHighs.length; j++) {
                for (int k = (j - 1) < 0 ? 0 : j - 1; k < highs.length; k++) {
                    curHighs[j] += highs[k];
                }
            }
            curHighs[highs.length] = 1;
            highs = curHighs;
            preNum = curNum;
        }
        System.out.println(System.currentTimeMillis() - start);
        return curNum;
    }

    public static void  main(String[] args){
        System.out.println(numTrees(10000));
    }

}
