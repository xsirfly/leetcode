package xsir;

/**
 * @author zhangcong
 * @date 2019/1/8
 */
public class Interval {

    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "Interval{" +
            "start=" + start +
            ", end=" + end +
            '}';
    }
}
