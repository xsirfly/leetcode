package xsir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/1/8
 */
public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        boolean isMerged;
        Collections.sort(intervals, (intervals1, intervals2) -> intervals1.start - intervals2.start);
        for (Interval interval : intervals) {
            isMerged = false;
            for (Interval merged : result) {
                if ((interval.end - interval.start) + (merged.end - merged.start)
                    >= Math.max(interval.end, merged.end) - Math.min(interval.start, merged.start)) {
                    merged.start = Math.min(interval.start, merged.start);
                    merged.end = Math.max(interval.end, merged.end);
                    isMerged = true;
                    break;
                }
            }
            if (!isMerged) {
                result.add(interval);
            }
        }
        return result;
    }

    public static void  main(String[] args){
//        [[1,3],[2,6],[8,10],[15,18]]
        List<Interval> res = merge(Arrays.asList(new Interval(2, 3),
            new Interval(4, 5), new Interval(1, 10)));
        System.out.println(res);
    }

}
