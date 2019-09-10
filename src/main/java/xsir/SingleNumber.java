package xsir;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 2 ^ 2);
    }
}
