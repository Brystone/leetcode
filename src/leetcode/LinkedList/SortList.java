package leetcode.LinkedList;



/**
 * 题目：148. 排序链表
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/4/3 21:57
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
    }
    //利用归并排序思想
    public ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }
    //切分链表，两个指针 一个一步 一个两步
    //递归归并
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head; //三个指针归并
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return head.next;
    }
}
