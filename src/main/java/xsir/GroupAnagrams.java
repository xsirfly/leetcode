package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangcong
 * @date 2019/1/4
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<List<String>>> code2str = new HashMap<>();
        for (String str : strs) {
            int code = 0;
            for (int i = 0; i < str.length(); i++) {
                code = code | (1 << str.charAt(i) - 'a');
            }
            code2str.compute(code, (key, old) -> {
                if (old == null) {
                    old = new ArrayList<>();
                }
                for (List<String> group : old) {
                    for (String member : group) {
                        if (isEqual(member, str)) {
                            group.add(str);
                            return old;
                        }
                    }
                }
                List<String> group = new ArrayList<>();
                group.add(str);
                old.add(group);
                return old;
            });
        }
        return code2str.values().stream()
            .flatMap(groups -> groups.stream()).collect(Collectors.toList());
    }

    public static boolean isEqual(String a, String b) {
        byte[] ab = a.getBytes();
        byte[] bb = b.getBytes();
        Arrays.sort(ab);
        Arrays.sort(bb);
        return new String(ab).equals(new String(bb));
    }

    public static void  main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat", "eatt"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }

}
