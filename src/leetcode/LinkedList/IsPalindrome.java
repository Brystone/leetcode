package leetcode.LinkedList;

/*
234[E]. Palindrome Linked List O(n) O(1)
Input: 1->2
Output: false
 */

public class IsPalindrome {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //两个指针 一个指向头，一个指向头节点下一个结点
        ListNode slow = head;
        ListNode fast = head.next;
        //如果时奇数节点，走2步到null，偶数节点走两步就到最后一个节点，这时都停下来，判断fast得知jie
        while (fast != null && fast.next != null) {
            slow = slow.next; //一次走一步
            fast = fast.next.next; //一次走两步
        }
        if (fast != null) { //偶数结点
            slow = slow.next; //slow来到下一结点
        }

        cut(head, slow); //切成两个链表 O(n/2)
        return isEqual(head, reverse(slow));  // o(n/2)
    }

    //切分链表
    public void cut(ListNode head, ListNode node) {
        while (head != node) {
            head = head.next; //head移动直到node结点
        }
    }

    //翻转链表 O(n)
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre.next = cur;
            pre = cur; // 分别移动
            cur = next;
        }
        return pre;
    }

    //遍历两个链表，只要有一个节点不相等，就返回false
    public boolean isEqual(ListNode head, ListNode head2) {
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
