package xsir;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int next = 0, tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != next) {
                    tmp = nums[next];
                    nums[next] = nums[i];
                    nums[i] = tmp;
                }
                next++;
            }
        }
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }


}
