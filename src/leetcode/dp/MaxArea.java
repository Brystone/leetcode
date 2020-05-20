package leetcode.dp;

/**
 * 题目：11. 盛最多水的容器
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/20 21:05
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0;
        int r =  height.length - 1; // 两个指针，每次移动较短长度; 
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r-l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
