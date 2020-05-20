package jianzhioffer.LinkList;


public class MeetingNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
   }

   //两个指针，一个移动一步，另一个移动两步，相遇则是环中的结点
    public static Node meetingNode(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head.next;
        if (slow == null) {
            return null;
        }
        Node fast = slow.next;
        while  (slow != null && fast != null) {
            if (slow == head) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    //找到了环中的任意一个结点计算出个数k，两个指针指向头结点，先让快指针移动k步，然后两个指针一起移动，相遇则是环的入口
    public static Node entryNodeOfLoop (Node head) {
        Node meetingNode = meetingNode(head);
        if (meetingNode == null) {
            return null;
        }

        //计算环中结点数目
        int count = 1;
        Node cur = meetingNode;
        while (cur != meetingNode) {
            cur = cur.next;
            count++;
        }
        //移动结点count步，相遇则为结点数
        Node ahead = head;
        for (int i=0; i<count; i++) {
            ahead = ahead.next;
        }
        Node behind = head;
        while (ahead != null && ahead != behind) {
            ahead = ahead.next;
            behind = behind.next;
        }
        //跳出循环找到
        return ahead;
    }

    //第二种方法定义两个指针，快指针走两步，慢指针走一步，相遇则表明有环，
    public static Node entryNodeOfLoop2(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {

            if (fast.next != null) {
                fast = head.next.next;
                slow = head.next;

                //执行if则有环，将fast指向头结点
                if (fast == slow) {
                    fast = head;
                }
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
            }
        }
        return slow;
    }

    public static void printListNode(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
}
    }

    public static void main(String[] args) {
        //链表中有环和无环
        Node head = new Node(1);
        head.next = new Node(2);
        Node node = new Node(3);
        head.next.next = node;//代表第三个结点
        node.next = new Node(4);
        node.next.next = node;

        //只有一个结点
        Node head1 = new Node(1);

        //链表头指针为空
        Node head2 = null;

        //printListNode(head);
        Node meet = entryNodeOfLoop2(head); //入口结点
        if (meet == null) {
            System.out.println("没有环");
        } else {
            System.out.println(meet.value);
        }
    }
}

