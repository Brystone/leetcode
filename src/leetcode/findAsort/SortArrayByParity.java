package leetcode.findAsort;

/**
 * 题目：905. 按奇偶排序数组
 * 思路：
 *
 * Arrays.sort()
 * 1.基本类型数组是 快排 O(n*logn)
 * 2.对象数组是归并   O(n*logn)  O(n)  空间复杂度
 * @author ：stone
 * @date ：Created in 2020/3/29 15:16
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length-1;

        while (l<r) {
            if (((A[l] & 1) == 0) && ((A[r] &1) == 1)){
                swap(A, l, r);
                l++;
                r--;
            } else if (((A[l] & 1) == 0)) {
                l++;
            } else r--;
        }
        return A;
    }
    public void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
