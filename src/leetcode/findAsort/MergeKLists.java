package leetcode.findAsort;

import leetcode.LinkedList.ListNode;

/**
 * 题目：
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/3/26 10:40
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    //归并排序的切分 
    private ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    //合并两个链表，不是每次都生成新的链表来存储
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else l2.next = merge(l1, l2.next);
        return l2;
    }
}
