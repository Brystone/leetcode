package jianzhioffer.LinkList;

/*
找到两个链表的第一个公共结点
 A:        a1 → a2
                    ↘
                      c1 → c2 → c3
                    ↗
B:    b1 → b2 → b3

思路：两个指针，同时从头结点出发，走到最后一个结点时，就从对方的头结点再往前走，直到两个结点相遇
 */
public class FindFirstCommonNode {
    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node findFirstCommonNode(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;
        //两个指针走
        while (p1 != p2) {
            p1 = (p1 == null ? head2:p1.next); //链表2的头结点  用next会超时
            p2 = (p2 == null ? head1:p2.next); //判断条件要用括号
        }
        return p1;
    }
}
