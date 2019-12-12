package xsir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> dict = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            dict.compute(prerequisite[0], (k, o) -> {
                Set<Integer> s;
                s = o == null ? new HashSet<>() : o;
                s.add(prerequisite[1]);
                return s;
            });
        }
        Set<Integer> hasChecked = new HashSet<>();
        Set<Integer> link = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasChecked.contains(i)) {
                continue;
            }
            if (!dict.containsKey(i)) {
                continue;
            }
            link.clear();
            link.add(i);
            if (hasCycle(dict, i, link, hasChecked)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycle(Map<Integer, Set<Integer>> dict, int i, Set<Integer> linked, Set<Integer> hasChecked) {
        if (!dict.containsKey(i)) {
            return false;
        }
        if (hasChecked.contains(i)) {
            return false;
        }
        Set<Integer> pres = dict.get(i);
        for (int pre : pres) {
            if (linked.contains(pre)) {
                return true;
            }
            linked.add(pre);
            if (hasCycle(dict, pre, linked, hasChecked)) {
                return true;
            }
            linked.remove(pre);
        }
        hasChecked.addAll(linked);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][]{
                {0, 1},
                {0, 2},
                {1, 2}
        }));
    }
}
