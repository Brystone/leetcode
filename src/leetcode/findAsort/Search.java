package leetcode.findAsort;

/**
 * 题目：33. Search in Rotated Sorted Array 在旋转数组中找到目标值索引，没有-1n log(n)
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/16 17:15
 */

public class Search {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左半边有序，常规的二分查找
            if (nums[l] <= nums[mid]) {
                if (nums[l] < target && target < nums[mid])  r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[mid] < target && target < nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}