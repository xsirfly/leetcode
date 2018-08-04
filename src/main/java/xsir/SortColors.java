package xsir;

public class SortColors {

    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1, currentIndex = 0;

        while (currentIndex <= end) {
            while (start < end && nums[start] == 0) start++;
            while (end > 0 && nums[end] == 2) end--;
            if (currentIndex < start) {
                currentIndex = start;
            }
            if (currentIndex > end) {
                break;
            }
            if (nums[currentIndex] == 0) {
                swap(nums, currentIndex, start);
                start++;
            } else if (nums[currentIndex] == 2) {
                swap(nums, currentIndex, end);
                end--;
            } else {
                currentIndex++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
