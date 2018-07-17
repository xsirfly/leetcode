package xsir;

import java.util.Scanner;

public class POJ3253 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plankNum = scanner.nextInt();
        int planks[] = new int[plankNum];
        for (int i = 0; i < plankNum; i++) {
            planks[i] = scanner.nextInt();
        }
        int result = 0;
        while (plankNum > 1) {
            result += sum(planks);
            int maxi = max(planks);
            planks[maxi] = 0;
            plankNum--;
        }
        System.out.println(result);
    }

    private static int sum(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    private static int max(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int maxi = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= arr[maxi]) {
                maxi = i;
            }
        }
        return maxi;
    }
}
