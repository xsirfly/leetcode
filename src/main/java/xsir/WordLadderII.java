package xsir;

import java.util.*;

public class WordLadderII {

    public static List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || beginWord == null || endWord == null) {
            return res;
        }
        Set<String> dict = new HashSet<>(wordList);
        Queue<List<String>> paths = new ArrayDeque<>();
        paths.add(Collections.singletonList(beginWord));
        int level = 1, minLevel = Integer.MAX_VALUE;
        List<String> words = new ArrayList<>();
        while (!paths.isEmpty()) {
            List<String> p = paths.poll();
            if (level < p.size()) {
                words.forEach(dict::remove);
                words.clear();
                level = p.size();
                if (level > minLevel) {
                    break;
                }
            }
            String last = p.get(p.size() - 1);
            for (int i = 0; i < last.length(); i++) {
                char[] newLastArr = last.toCharArray();
                char origin = newLastArr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (origin == c) {
                        continue;
                    }
                    newLastArr[i] = c;
                    String newLast = new String(newLastArr);
                    if (dict.contains(newLast)) {
                        words.add(newLast);
                        List<String> newp = new ArrayList<>(p);
                        newp.add(newLast);
                        if (newLast.equals(endWord)) {
                            res.add(newp);
                            minLevel = Math.min(minLevel, newp.size());
                        } else {
                            paths.add(newp);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(res);
    }
}
