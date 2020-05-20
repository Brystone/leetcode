package leetcode.findAsort;

import java.util.Arrays;

/**
 * 题目：350. Intersection of Two Arrays II
 * 将连续相等的数复制原数组的前面，
 * 思路：1.先对两个数组排序
 *      2.设置两个指针，遍历两个数组，肯定不能超过数组的长度
 *      3.比较数组值，nums1值大，i++，小 j++, == 使用新数组存储值，同时 i和j移动到下一个位置
 *
 * @author ：stone
 * @date ：Created in 2020/2/2 22:04
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        //int[] arr = new int[Integer.MAX_VALUE];
        int i =0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] < nums1[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            }
         }
         return Arrays.copyOfRange(nums1, 0, k); //返回新数组
    }
}
