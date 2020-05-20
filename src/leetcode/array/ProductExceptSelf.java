package leetcode.array;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：238. Product of Array Except Self 除本身之外的数组之积
 *[1, 2, 3, 4] -->[23, 12, 8, 6]
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/15 11:01
 */

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1]; // -->[1, 1, 2, 6]
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i]; //[1, 2, 3, 4]
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4};
        int[] res =  (productExceptSelf(arr));
        List<Integer> list = new ArrayList<>();
        for (int n: res) {
            list.add(n);
        }
        System.out.println(list);
    }
}
