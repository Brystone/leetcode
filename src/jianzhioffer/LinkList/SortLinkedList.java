package jianzhioffer.LinkList;

/**
 * 题目：对链表排序，归并排序
 * 思路：
 *
 * @author ：stone
 * @date ：Created in 2020/2/6 15:01
 */
public class SortLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node sortLinkedList(Node head) {
        if (head == null) {
            return head;
        }
        sortLinkedListed(head);
        return head;
    }

    public Node sortLinkedListed(Node head) {
        Node mid = getMid(head);
        Node second = mid.next; //拆分成两个链表
        mid.next = null; //第一链表尾节点置为空
        sortLinkedListed(head);
        sortLinkedListed(second);
        return merge(head, second);
    }

    public Node getMid(Node head) {
        //两个指针，快的走两步，慢的走一步，返回慢的指针位置
        Node slow = head;
        Node fast = head;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //合并两个有序的链表
    public Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node mergeHead = null;
        //取头节点较小的
        if (head1.value < head2.value) {
            mergeHead = head1;
            mergeHead.next = merge(mergeHead.next, head2);
        }
        if (head1.value > head2.value) {
            mergeHead = head2;
            mergeHead.next = merge(mergeHead.next, head1);
        }
        return mergeHead;
    }
}
