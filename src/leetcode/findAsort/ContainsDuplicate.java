package leetcode.findAsort;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/1 18:53
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i< nums.length; i++) {
            while (nums[i] != i) {
                // 现在nums[i] != i ，设nums[i] = j,所以如果下面的if成立,就是nums[i] == nums[j],说明找到 重复
                if (nums[i] == nums[nums[i]]) {
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }
    // 交换nums[i]和nums[nums[i]]
    private void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
