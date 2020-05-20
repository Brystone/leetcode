package leetcode.findAsort;

/**
 * 题目：162. Find Peak Element 找到峰值，在数组中找到比左右都大的数字
 * 思路：二分查找
 * 1.如果数组只有一个数，直接返回
 * 2.若数组只有两个数，返回大的那个
 * 3.和前后数比较，来缩小范围，nums[i-1]<nums[i]>nums[i+1] 返回i
 *                          nums[i-1]<nums[i]<nums[i+1] l = i + 1,到数组中右边找
 *                          nums[i-1]>nums[i]>nums[i+1] R = mid-1,到数组左边找
 *
 *
 *
 * @author ：stone
 * @date ：Created in 2020/2/10 13:29
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        while (l<r) {
            //如果只有两个元素，返回大的即可
            if (l+1 == r) {
                return nums[l] > nums[r] ? l : r;
            }
            int mid = l + (r -l) / 2;
            if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
