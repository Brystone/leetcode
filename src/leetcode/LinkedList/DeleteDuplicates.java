package leetcode.LinkedList;

/*
83 Input: 1->1->2
   Output:1->2

   删除相同的结点，保留一个。使用指针跳转的方式
 */
public class DeleteDuplicates {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while(cur.next != null && cur.next != null){
            if(cur.val == cur.next.val)
                cur.next = cur.next.next; //值相同就跳到下一个不同的值
            else
                cur = cur.next; //不同就继续向前比较
        }
        return head;
    }
}
