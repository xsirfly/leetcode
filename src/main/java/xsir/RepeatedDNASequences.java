package xsir;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + 10 <= s.length()) {
                dict.compute(s.substring(i, i + 10), (sub, oldv) -> oldv == null ? 1 : oldv + 1);
            }
        }
        return dict.entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
