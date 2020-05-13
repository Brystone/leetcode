package leetcode.hashtable;

/*
1E. Two Sum  返回和在数组中两个数的索引
Given nums = [2, 7, 11, 15], target = 9,  return [0, 1].

思路： 用hashMap存储元素和索引的映射，查找nums[i]时，判断map中是否存在target-nums[i]，如果存在则返回两个数的索引
T(n) = O(n) S(n) = O(n)
 */

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        //跳出循环的表示找不到索引
        return null;
    }
}
