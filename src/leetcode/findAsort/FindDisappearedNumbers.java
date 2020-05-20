package leetcode.findAsort;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：448. Find All Numbers Disappeared in an Array   1=<n<=nums.length; 无序数组中缺失的数
 * O(n), 不消耗额外的空间
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/15 15:24
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        //排序过程，因为数组元素都在数组大小范围内，人如果不缺失元素，么=那么数组元素-1和对应索引必然相等
        for (int i=0; i<nums.length; i++) {
            while(nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
        //排好序的数组
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                list.add(i+1);
            }
        }
        return list;
    }
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
