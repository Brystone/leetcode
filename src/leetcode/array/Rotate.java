package leetcode.array;

/**
 * 题目：189. 旋转数组 给定k，旋转k次，
 * 思路：可能k大于数组长度，比如k=8，数组长度为7 对数组长度取余代表要旋转的次数
 *
 * @author ：stone
 * @date ：Created in 2020/3/22 11:05
 */
public class Rotate {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
        Rotate rotate = new Rotate();
        rotate.rotate(a,8);
        for (int n:a) {
            System.out.println(n);
        }
    }
}












