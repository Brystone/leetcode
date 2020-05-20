package leetcode.LinkedList;

/**
 * 题目：287. Find the Duplicate Number
 * [1,3,4,2,2] 无序，每个数都在 1-n之间 并且只有一个重复值
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/15 22:57
 */
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        // Find the intersection point of the two runners.
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 3, 6, 7};
        int[] arr = new int[] {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(arr));
    }
}
