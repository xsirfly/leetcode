package xsir;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> tallest = new Stack<>();
        Stack<Integer> index = new Stack<>();
        int maxArea = heights[0];
        tallest.push(heights[0]);
        index.push(0);
        int lastIndex = 0;
        int tmpArea = 0;
        for (int i = 1; i < heights.length; i++) {
            if (i == heights.length - 1 || heights[i] > heights[i + 1]) {
                for (int j = tallest.size() - 1; j >= 0; j--) {
                    tmpArea = Math.max(Math.min(tallest.get(j), heights[i]) * (i - index.get(j) + 1), heights[i]);
                    maxArea = Math.max(tmpArea, maxArea);
                }
            }
            lastIndex = i;
            while(!tallest.isEmpty() && tallest.peek() > heights[i]) {
                tallest.pop();
                lastIndex = index.pop();
            }
            tallest.push(heights[i]);
            index.push(lastIndex);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
