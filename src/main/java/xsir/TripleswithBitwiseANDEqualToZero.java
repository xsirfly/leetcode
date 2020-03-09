package xsir;

public class TripleswithBitwiseANDEqualToZero {
    public static int countTriplets(int[] A) {
        return count(A, -1, 0);
    }

    private static int count(int[] A, int curRes, int num) {
        if (num == 3) {
            return curRes == 0 ? 1 : 0;
        }
        int cnt = 0;
        for (int value : A) {
            cnt += count(A, curRes & value, num + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 1, 3}));
    }
}
