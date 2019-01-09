package xsir;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangcong
 * @date 2019/1/9
 */
public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        boolean isMerged = false, isAdded = false;
        List<Interval> result = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if ((interval.end - interval.start) + (newInterval.end - newInterval.start) 
                >= Math.max(interval.end, newInterval.end) - Math.min(interval.start, newInterval.start)) {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
                isMerged = true;
            } else {
                if (isMerged) {
                    result.add(newInterval);
                    result.addAll(intervals.subList(i, intervals.size()));
                    isAdded = true;
                    break;
                } else {
                    if (newInterval.start < interval.start) {
                        result.add(newInterval);
                        result.addAll(intervals.subList(i, intervals.size()));
                        isAdded = true;
                        isMerged = true;
                        break;
                    }
                    result.add(interval);
                }
            }
        }
        if (!isMerged || !isAdded) {
            result.add(newInterval);
        }
        return result;
    }
    
    public static void  main(String[] args) {
//        [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        System.out.println(insert(Arrays.asList(new Interval(1, 5)), new Interval(0, 0)));
    }

}
