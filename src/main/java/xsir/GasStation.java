package xsir;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            if (canCompleteCircuit(gas, cost, (i + 1) % gas.length, i, gas[i] - cost[i])) {
                return i;
            }
        }
        return -1;
    }

    private static boolean canCompleteCircuit(int[]gas, int[] cost, int cur, int target, int left) {
        if (cur == target) {
            return true;
        }
        if (left + gas[cur] - cost[cur] < 0) {
            return false;
        }
        return canCompleteCircuit(gas, cost, (cur + 1) % gas.length, target, left + gas[cur] - cost[cur]);
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 4}));
    }
}
