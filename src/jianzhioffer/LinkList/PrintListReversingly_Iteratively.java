package jianzhioffer.LinkList;

import java.util.Stack;

/*
206. Reverse Linked List 逆序输出链表
     Input: 1->2->3->4->5->NULL
     Output: 5->4->3->2->1->NULL

     思路：1. 用栈  2. 先遍历链表，确认结点个数；
 */
public class
PrintListReversingly_Iteratively {
//三个指针
    public static int[] printNode(ListNode head) {
        ListNode node = head;
        int count = 0;
        //遍历一遍链表，记录链表结点个数
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] nums = new int[count];
        //遍历第二遍链表， 第一个结点入数组索引最后一个位置
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int cnt = 0; //自定义数组的索引
        while(!stack.isEmpty()) {
            res[cnt++] = stack.pop();
        }
        return res;
    }
}

