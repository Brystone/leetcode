package jianzhioffer.LinkList;

/*
合并两个有序的链表 使用递归方法,比较两个链表的头结点，取出小的，然后接着比较两个链表头结点。取出的头结点那个链表头结点变为下一个结点
 */

public class MergeSortedLists {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
        }
    }

    //O(N) 速度快，占用空间少
    public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
        //边界
        if (l1 == null) {  //注意这里的边界
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode mergeHead = null;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeSortedLists(l1.next, l2);//返回的是一个新的头结点
        } else {
            mergeHead = l2;
            mergeHead.next = mergeSortedLists(l2.next, l1);
        }
        return mergeHead;
    }
}
