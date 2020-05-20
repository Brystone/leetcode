package leetcode.LinkedList;

/**
 * 题目：141. Linked List Cycle
 * 思路：快慢指针指向头节点，，慢一次走一步，快一次走两步，相等就有环
 * 否则无
 *
 * @author ：stone
 * @date ：Created in 2020/3/8 19:05
 */
public class HasCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //如果时奇数节点，走2步到null，偶数节点走两步就到最后一个节点，这时都停下来，判断fast得奇偶
        while (fast != null && fast.next != null) {
            slow = slow.next; //一次走一步
            fast = fast.next.next; //一次走两步
        }
        if (slow == fast) {
            return true;
        }
        return false;
    }
}


