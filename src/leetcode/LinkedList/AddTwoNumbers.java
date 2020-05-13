package leetcode.LinkedList;
import java.util.Stack;
/*
445M. Add Two Numbers II

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7 得到新链表

O(n), 借助栈，加完以后取个位数（a%10），使用头插法插入结点，再使用a/10得到进位保存 在下一次计算时候加上
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //链表入栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode head = new ListNode(-2);
        ListNode cur = head; //头插法指向头节点的指针
        int carry = 0;  //进位值

        //O(n)
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        //O(n)
        while (l2 != null) {
            stack2.push(l2.val); // 值入栈
            l2 = l2.next;
        }
        //头插法 O(1)
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) { //判断边界
            int x = stack1.isEmpty() ? 0: stack1.pop();
            int y = stack2.isEmpty() ? 0: stack2.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10); //取和的个位数值
            node.next = cur.next;
            cur.next = node;
            carry = sum / 10; //取十位数，下一次相加时候加上
        }
        return head.next;
    }
}
