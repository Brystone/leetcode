package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/*
217. Contains Duplicate  判断数组中是否有重复值
Input: [1,2,3,1]
Output: true

思路：使用HashSet集合的唯一特性，
比较set和nums数组的长度是否相等
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //遍历数组
        for (int num: nums) {
            set.add(num);
        }
        return set.size() < nums.length; // 小于即数组中有重复的值
    }
}
