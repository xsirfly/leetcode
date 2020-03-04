package xsir;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> c2c = new HashMap<>();
        Map<Character, Boolean> c2v = new HashMap<>();
        Deque<Character> q = new ArrayDeque<>();
        Character cur, last;
        for (int i = 0; i < s.length(); i++) {
            c2c.compute(s.charAt(i), (k, old) -> old == null ? 1 : old + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            c2c.computeIfPresent(cur, (k, old) -> old - 1);
            if (Boolean.TRUE.equals(c2v.get(s.charAt(i)))) {
                continue;
            }

            while (!q.isEmpty() && cur < (last = q.peekLast()) && c2c.get(last) > 0) {
                q.pollLast();
                c2v.put(last, false);
            }
            c2v.put(cur, true);
            q.addLast(cur);
        }
        StringBuilder sb = new StringBuilder();
        q.forEach(sb::append);
        return sb.toString();
    }

//    private static String remove(String s, Set<Integer> removeIndex, Map<Character, List<Integer>> c2i) {
//        boolean isUni = true;
//        for (Map.Entry<Character, List<Integer>> entry : c2i.entrySet()) {
//            if (entry.getValue().stream().filter(i -> i >= 0).count() > 1) {
//                isUni = false;
//                break;
//            }
//        }
//        if (isUni) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < s.length(); i++) {
//                if (!removeIndex.contains(i)) {
//                    sb.append(s.charAt(i));
//                }
//            }
//            return sb.toString();
//        }
//        String min = null;
//        for (Map.Entry<Character, List<Integer>> entry : c2i.entrySet()) {
//            if (entry.getValue().stream().filter(i -> i >= 0).count() <= 1) {
//                continue;
//            }
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                if (entry.getValue().get(i) < 0) {
//                    continue;
//                }
//                int old = entry.getValue().set(i, -1);
//                removeIndex.add(old);
//                String res = remove(s, removeIndex, c2i);
//                entry.getValue().set(i, old);
//                removeIndex.remove(old);
//                if (min == null || res.compareTo(min) < 0) {
//                    min = res;
//                }
//
//            }
//        }
//        return min;
//    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bbcaac"));
    }
}
