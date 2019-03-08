package xsir;

/**
 * @author zhangcong
 * @date 2019/3/8
 */
public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int start = 0, end = matrix.length - 1, mid = 0;
        int targetRow = 0;
        while (end > start) {
            mid = (start + end) >> 1;
            if (mid == start) {
                targetRow = matrix[end][0] > target ? start : end;
                break;
            }
            if (matrix[mid][0] > target) {
                end = mid;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                return true;
            }
        }

        start = 0;
        end = matrix[0].length - 1;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (matrix[targetRow][mid] == target) {
                return true;
            } else if (matrix[targetRow][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
            if (end - start <= 1) {
                return matrix[targetRow][end] == target;
            }
        }
        return false;
    }

    public static void  main(String[] args){
        int[][] matrix = {{1}};

        System.out.println(searchMatrix(matrix, 1));
    }

}
