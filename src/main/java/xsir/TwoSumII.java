package xsir;

/**
 * @author zhangcong
 * @date 2019/4/30
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null) {
            return res;
        }
        int s = 0, e = numbers.length - 1, sum;
        while (s < e) {
            sum = numbers[s] + numbers[e];
            if (sum == target) {
                res[0] = s + 1;
                res[1] = e + 1;
                return res;
            } else if (sum > target) {
                e--;
            } else {
                s++;
            }
        }
        return res;
    }

}
