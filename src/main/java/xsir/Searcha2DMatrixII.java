package xsir;

public class Searcha2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int start = 0, end = matrix[0].length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (matrix[0][mid] == target) {
                return true;
            } else if (matrix[0][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        mid = matrix[0][mid] > target ? mid - 1 : mid;
        if (mid < 0) {
            return false;
        }
        int colMid = 0;
        start = 0; end = matrix.length - 1;
        while (start <= end) {
            colMid = (start + end) >> 1;
            if (matrix[colMid][mid] == target) {
                return true;
            } else if (matrix[colMid][mid] > target){
                end = colMid - 1;
            } else {
                start = colMid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix(matrix, 5));
    }
}
