package leetcode.array;

/**
 * 题目：169. Majority Element
 * Input: [3,2,3]
 * Output: 3
 * 思路： Moore's voting algorithm
 * 每次不同的有元素就从将指针移到下一个元素位置
 * 1.首先给主要元素指针指向数组第一个元素，计数器设为1
 * 2.遍历数组，发现和主要元素相同，计数器就+1，否则-1
 * 3.比较完后判断count是否为0，为0说明和主要元素不相等，删除 将指针移到当前元素位置，并且将count置为1
 * @author ：stone
 * @date ：Created in 2020/1/31 19:51
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
      if (nums.length == 1) {
          return nums[0];
      }
      int majorIndex = 0, count = 1;
      for (int i=0; i<nums.length; i++) {
          if (nums[i] == nums[majorIndex]) {
              count++;
          } else {
              count--;
          }
          if (count == 0) {
              majorIndex = i;
              count = 1;
          }
      }
      return nums[majorIndex];
    }
}
