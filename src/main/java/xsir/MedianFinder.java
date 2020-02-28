package xsir;

import java.util.*;

public class MedianFinder {

    private Queue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    private Queue<Integer> right = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {}

    public void addNum(int num) {
        if (left.isEmpty()) {
            left.add(num);
            return;
        }
        int diff = left.size() - right.size();
        if (diff == 0) {
            if (num > left.peek()) {
                right.add(num);
            } else {
                left.add(num);
            }
        } else if (diff == 1) {
            if (num > left.peek()) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        } else {
            if (num > right.peek()) {
                left.add(right.poll());
                right.add(num);
            } else {
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2;
        } else {
            return right.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
//        finder.addNum(6);
//        System.out.println(finder.findMedian());
//        finder.addNum(10);
//        System.out.println(finder.findMedian());
//        finder.addNum(2);
//        System.out.println(finder.findMedian());
//        finder.addNum(6);
//        System.out.println(finder.findMedian());
//        finder.addNum(5);
//        System.out.println(finder.findMedian());
//        finder.addNum(0);
//        System.out.println(finder.findMedian());
//        finder.addNum(6);
//        System.out.println(finder.findMedian());
//        finder.addNum(3);
//        System.out.println(finder.findMedian());
//        finder.addNum(1);
//        System.out.println(finder.findMedian());
//        finder.addNum(0);
//        System.out.println(finder.findMedian());
//        finder.addNum(0);
//        System.out.println(finder.findMedian());
        finder.addNum(12);
        System.out.println(finder.findMedian());
        finder.addNum(10);
        System.out.println(finder.findMedian());
        finder.addNum(13);
        System.out.println(finder.findMedian());
        finder.addNum(11);
        System.out.println(finder.findMedian());
        finder.addNum(5);
        System.out.println(finder.findMedian());
        finder.addNum(15);
        System.out.println(finder.findMedian());
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(11);
        System.out.println(finder.findMedian());
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(17);
        System.out.println(finder.findMedian());
        finder.addNum(14);
        System.out.println(finder.findMedian());
        finder.addNum(8);
        System.out.println(finder.findMedian());
        finder.addNum(17);
        System.out.println(finder.findMedian());
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(4);
        System.out.println(finder.findMedian());
        finder.addNum(14);
        System.out.println(finder.findMedian());
    }
}
