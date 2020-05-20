package leetcode.findAsort;

/**
 * 题目：34. Find First and Last Position of Element in Sorted Array  重复的数一定是两个
 * [1, 2, 3, 3, 6, 6, 7] t : 6 --> [4, 5]  target = 8 -->[-1, -1]
 *
 * 思路：二分查找，这里将循环条件设为 while(nums[lo] < nums[hi]) 如果 nums[lo] == target, high-- 否则 lo++;
 * 检验是否是目标值 条件是 num[lo] == nums[hi] && nums[lo] == target
 *
 * @author ：stone
 * @date ：Created in 2020/2/11 20:09
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        int lo = 0, hi = nums.length - 1;

        //
        while (nums[lo] < nums[hi]) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                if (nums[lo] == target) { //这里缩小范围
                    hi--;
                } else {
                    lo++;
                }
            }
        }
        if (nums[lo] == target && target == nums[hi]) {
            res[0] = lo;
            res[1] = hi;
        }
        return res;
     }

     public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 3, 6, 6, 7};
        int[] b = searchRange(a, 6);
        for (int n: b) {
            System.out.println(n);
        }
     }
}
