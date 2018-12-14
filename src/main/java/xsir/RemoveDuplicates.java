package xsir;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int lastIndex = 1, tmp;
        Integer lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                lastNum = nums[i];
                if (lastIndex != i) {
                    tmp = nums[i];
                    nums[i] = nums[lastIndex];
                    nums[lastIndex] = tmp;
                }
                lastIndex++;
            }
        }
        return lastIndex;
    }
}
