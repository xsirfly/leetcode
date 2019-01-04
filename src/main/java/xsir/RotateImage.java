package xsir;

import java.util.Arrays;

/**
 * @author zhangcong
 * @date 2019/1/3
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int x, y, pre, tmp, tmpx;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length - 2 * i -1; j++) {
                x = i;
                y = i + j;
                pre = matrix[x][y];
                for (int k = 0; k < 4; k++) {
                    tmpx = x;
                    x = y;
                    y = matrix.length - tmpx - 1;
                    tmp = matrix[x][y];
                    matrix[x][y] = pre;
                    pre = tmp;
                }
            }
        }
    }
    
    public static void  main(String[] args){
        int[][] res = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
        rotate(res);
        System.out.println(Arrays.toString(res));
    }
    
}
