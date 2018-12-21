package xsir;

/**
 * @author zhangcong
 * @date 2018/12/21
 */
public class SearchInsertPos {

    public static int searchInsert(int[] nums, int target) {
        int mid, start = 0, end = nums.length - 1;
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
        if (nums[end] < target) {
            return end + 1;
        }
        return (end > 0 && nums[end - 1] > target) ? end - 1 : end;
    }
    
    public static void  main(String[] args){
        int res = searchInsert(new int[] {1}, 0);
        System.out.println(res);
    }

}
