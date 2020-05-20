package jianzhioffer.LinkList;

import java.util.List;

/*
找到链表中倒数第K个结点
用两个指针，第一个先向前移动k-1步，然后两个指针一起移动，直到第一个指针指向最后一个结点，返回慢指针的值
*/
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public  ListNode findKThToTail(ListNode head, int k) {
        if (head == null | k == 0) {
            return null;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;

        for (int i=1; i<k; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.next;
    }
}
