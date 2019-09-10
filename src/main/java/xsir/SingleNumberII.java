package xsir;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> v2t = new HashMap<>();
        Arrays.stream(nums).forEach(n -> v2t.compute(n, (nv, ov) -> ov == null ? 1 : ov + 1));
        return v2t.entrySet().stream().filter((entry -> entry.getValue() == 1)).map(Map.Entry::getKey).findFirst().get();
    }
}
