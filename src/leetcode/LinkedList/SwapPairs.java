package leetcode.LinkedList;
/*
24M. Swap Nodes in Pairs
Given 1->2->3->4, you should return the list as 2->1->4->3
设置 dummy 链上链表
初始化第一、第二个结点为链表对应的两个结点
先将第一个和第三个结点链上 first.enxt = second.next; 1->3->4
再将原第二个结点链上第一个结点  second.next = first; 2->1->3->4
将cur结点链上链表 cur.next = second; cur->2->1->3->4
cur移动两步; 来到1位置，f和s分别移动到下一个位置
*/
public class SwapPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
