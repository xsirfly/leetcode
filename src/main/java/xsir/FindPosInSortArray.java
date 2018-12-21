package xsir;

import java.util.Arrays;

/**
 * @author zhangcong
 * @date 2018/12/21
 */
public class FindPosInSortArray {

    public static int[] searchRange(int[] nums, int target) {
        int index = binSearch(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[] {-1, -1};
        }
        int left = findLeft(nums, 0, index -1, target);
        int right = findRight(nums, index + 1, nums.length - 1, target);
        left = left == -1 ? index : left;
        right = right == -1 ? index : right;
        return new int[]{left, right};
    }

    public static int findLeft(int[] nums, int start, int end, int target) {
        int index = binSearch(nums, start, end, target);
        if (index != -1) {
            int left = findLeft(nums, start, index - 1, target);
            return left == -1 ? index : left;
        }
        return -1;
    }

    public static int findRight(int[] nums, int start, int end, int target) {
        int index = binSearch(nums, start, end, target);
        if (index != -1) {
            int right = findRight(nums, index + 1, end, target);
            return right == -1 ? index : right;
        }
        return -1;
    }

    public static int binSearch(int[] nums, int start, int end, int target) {
        int mid;
        while (end >= start) {
            mid = (start + end) >> 1;
            if (mid == start && nums[mid] != target) {
                start++;
                continue;
            }
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void  main(String[] args){
        int[] res = searchRange(new int[]{1,1,1,2,4,4,4,5,5,5,5,6,7,8,8,9,9,9,9,9,9,10}, 9);
        System.out.println(Arrays.toString(res));
    }

}
