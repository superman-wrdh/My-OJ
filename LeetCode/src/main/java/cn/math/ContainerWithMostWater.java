package cn.math;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int L = 0;
        int R = height.length - 1;
        int maxArea = 0;
        while (L < R) {

            int W = R - L;
            int H = height[L] <= height[R] ? height[L] : height[R];
            maxArea = Math.max(maxArea, W * H);

            if (height[L] <= height[R]) {
                L++;
            } else if (height[L] > height[R]) {
                R--;
            }
        }
        return maxArea;
    }
}
