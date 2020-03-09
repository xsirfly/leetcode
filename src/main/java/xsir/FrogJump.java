package xsir;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones.length < 2) {
            return false;
        }
        Set<Integer> s = Arrays.stream(stones).boxed().collect(Collectors.toSet());
        if (stones[0] + 1 != stones[1]) {
            return false;
        }
        return find(s, stones[1], 1, stones[stones.length - 1]);
    }

    private boolean find(Set<Integer> stones, int cur, int k, int target) {
        if (cur == target) {
            return true;
        }
        if (k - 1 > 0 && stones.contains(cur + (k - 1))) {
            if (find(stones, cur + k - 1, k - 1, target)) {
                return true;
            }
        }

        if (stones.contains(cur + k)) {
            if (find(stones, cur + k, k, target)) {
                return true;
            }
        }

        if (stones.contains(cur + k + 1)) {
            if (find(stones, cur + k + 1, k + 1, target)) {
                return true;
            }
        }

        return false;
    }
}
