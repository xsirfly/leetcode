package xsir;

/**
 * @author zhangcong
 * @date 2018/12/20
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int rotateIndex = findRotateIndex(nums);
        int resLeft = binSearch(nums, 0, rotateIndex, target);
        int resRight = binSearch(nums, rotateIndex + 1, nums.length - 1, target);
        return resLeft + resRight + 1;
    }

    public static int findRotateIndex(int[] nums) {
        int mid = -1, start = 0, end = nums.length - 1;
        while (end > start) {
            mid = (start + end) >> 1;
            if (mid == start && (nums[mid] > nums[end] || nums[mid] < nums[start])) {
                start++;
                continue;
            }
            if (nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[start]){
                end = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }

    public static int binSearch(int[] nums, int start, int end, int target) {
        int mid;
        while (end >= start) {
            mid = (start + end) >> 1;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                return mid;
            }
            if (mid == start && nums[mid] != target) {
                start++;
                continue;
            }
        }
        return -1;
    }
    
    public static void  main(String[] args){
        int res = search(new int[] {1, 3}, 1);
        System.out.println(res);
    }

}
