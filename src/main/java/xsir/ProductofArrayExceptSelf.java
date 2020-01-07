package xsir;

public class ProductofArrayExceptSelf {
//    public int[] productExceptSelf(int[] nums) {
//        int[] left = new int[nums.length];
//        int[] right = new int[nums.length];
//        int[] output = new int[nums.length];
//        int product = 1;
//        for (int i = 0; i < nums.length; i++) {
//            left[i] = product * nums[i];
//            product = left[i];
//        }
//        product = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            right[i] = product * nums[i];
//            product = right[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            output[i] = (i - 1 >= 0 ? left[i - 1] : 1) * (i + 1 < nums.length ? right[i + 1] : 1);
//        }
//        return output;
//    }
public int[] productExceptSelf(int[] nums) {
    int[] output = new int[nums.length];
    int product = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        output[i] = product * nums[i];
        product = output[i];
    }

    product = 1;
    for (int i = 0; i < nums.length; i++) {
        output[i] = product * (i + 1 < nums.length ? output[i + 1] : 1);
        product = product * nums[i];
    }
    return output;
}
}
