package leetcode.bitopration;

/**
 * 题目：169 多数元素
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/4 20:25
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int cand_num = nums[0], count = 1;
        for (int i=1; i<nums.length; i++) {
            if (cand_num == nums[i]) count++;
            else if (count-- == 0){ //优化一下
                    cand_num = nums[i];
                    count = 1;
            }
        }
        return cand_num;
    }
}
