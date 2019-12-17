package xsir;

import java.util.*;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> dict = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            dict.compute(prerequisite[0], (k, o) -> {
                Set<Integer> s;
                s = o == null ? new HashSet<>() : o;
                s.add(prerequisite[1]);
                return s;
            });
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> tmpRes = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (res.contains(i)) {
                continue;
            }
            if (!dict.containsKey(i)) {
                res.add(i);
                continue;
            }
            tmpRes.clear();
            tmpRes.add(i);
            if (hasCycle(dict, i, res, tmpRes)) {
                return new int[]{};
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private static boolean hasCycle(Map<Integer, Set<Integer>> dict, int i, List<Integer> res, List<Integer> tmpRes) {
        if (res.contains(i)) {
            return false;
        }
        if (!dict.containsKey(i)) {
            res.add(i);
            return false;
        }
        Set<Integer> pres = dict.get(i);
        for (int pre : pres) {
            if (tmpRes.contains(pre)) {
                return true;
            }
            tmpRes.add(pre);
            if (hasCycle(dict, pre, res, tmpRes)) {
                return true;
            }
            tmpRes.remove((Object)pre);
        }
        res.add(i);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(3, new int[][]{
                {0, 1},
                {0, 2},
                {1, 2}
        })));
    }
}
