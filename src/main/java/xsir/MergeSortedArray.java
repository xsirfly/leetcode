package xsir;

import java.util.Arrays;

/**
 * @author zhangcong
 * @date 2019/4/15
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, cur = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[cur] = nums2[j--];
            } else if (j < 0) {
                break;
            } else if (nums1[i] < nums2[j]) {
                nums1[cur] = nums2[j];
                j--;
            } else {
                nums1[cur] = nums1[i];
                i--;
            }
            cur--;
        }
    }

    public static void  main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
