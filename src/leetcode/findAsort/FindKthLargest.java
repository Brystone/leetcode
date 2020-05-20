package leetcode.findAsort;

import java.util.PriorityQueue;

/**
 * 题目：215. Kth Largest Element in an Array
 *       找到数组中第k个大的元素，
 * 思路：和最小的k个元素思路一样，返回堆顶 大顶堆
 * 用小顶堆 实现优先队列
 *
 * @author ：stone
 * @date ：Created in 2020/3/16 12:03
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //小顶堆

        for (int n:nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return  pq.peek();
    }
}
