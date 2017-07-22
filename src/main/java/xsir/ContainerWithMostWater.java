package xsir;

import java.util.*;

/**
 * Created by zhangcong on 2017/7/22.
 */
public class ContainerWithMostWater {

    class Pair {
        public int index;
        public int height;
        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (height[i] < height[j] ? height[i] : height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        if (height == null || height.length == 1) {
            throw new RuntimeException("params error, height has 2 element at least!!!");
        }
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int maxArea = 0, maxHeight = 0, maxIndex = 0;
        Stack<Pair> ends = new Stack<Pair>();
        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] > height[i + 1]) {
                while (!ends.isEmpty() && ends.peek().height <= height[i]) {
                    ends.pop();
                }
                ends.push(new Pair(i, height[i]));
            }
        }
        if (ends.size() >= 1) {
            for (int i = 0; i < ends.get(0).index; i++) {
                int area = Math.min(height[i], ends.get(0).height) * (ends.get(0).index - i);
                if (area > maxArea) {
                    maxArea = area;
                    maxHeight = Math.min(height[i], ends.get(0).height);
                    maxIndex = i;
                }
            }
            for (int i = 1; i < ends.size(); i++) {
                Pair lastEnd = ends.get(i - 1);
                Pair end = ends.get(i);
                int addArea = Math.min(maxHeight, end.height) * (end.index - maxIndex);
                int area = Math.min(end.height, lastEnd.height) * (end.index - lastEnd.index);
                if (addArea < maxArea && area < maxArea) {
                    continue;
                }
                if (addArea > area) {
                    maxArea = addArea;
                    maxHeight = Math.min(maxHeight, end.height);
                } else {
                    maxArea = area;
                    maxHeight = Math.min(end.height, lastEnd.height);
                    maxIndex = lastEnd.index;
                }
            }
        }
        for (int i = 0; i < height.length - 1; i++) {
            int area = Math.min(height[i], height[height.length - 1]) * (height.length - 1 - i);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public int maxArea3(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
