package leetcode.LinkedList;

/*
19. Remove Nth Node From End of List  O(n)
1->2->3->4->5, and n = 2
1->2->3->5
 */
public class RemoveNthFromEnd {
    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null | n == 0) {
            return null;
        }
        ListNode start = new ListNode(-1);
        start.next = head; //链上链表

        ListNode fast = start;
        ListNode slow = start;

        for (int i=0; i<n; i++) {
            fast = fast.next; //fast向前n+1步
        }
        while(fast.next != null) {  //f走到最后一个结点停下来
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

}
