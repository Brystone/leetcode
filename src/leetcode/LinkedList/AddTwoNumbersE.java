package leetcode.LinkedList;

/*
2. Add Two Numbers 新的链表 O(n)
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

 */
public class AddTwoNumbersE {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1); //随意指定一个结点
        ListNode cur = head; //指向头结点的指针，不停向前移动添加指针\

        int carry = 0;
        //队列元素相加，若对应链表元素为null，则赋值为0 即便两个结点都为空值了也要把进位加上
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 == null) ? 0:l1.val;
            int y = (l2 == null) ? 0:l2.val;
            int sum = x + y + carry;


            ListNode node = new ListNode(sum % 10); //取余
            cur.next = node;
            cur = node;
            carry = sum / 10; //除以10取进位放到下一次相加
            l1 = (l1 == null) ? l1:l1.next; //
            l2 = (l2 == null) ? l2:l2.next;

        }
        return head.next;
    }
}