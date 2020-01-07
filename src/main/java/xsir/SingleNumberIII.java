package xsir;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int diff = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff = diff ^ nums[i];
        }
        diff = diff & (0 - diff);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0) res[0] = res[0] ^ nums[i];
            else res[1] = res[1] ^ nums[i];
        }
        return res;
    }
}
