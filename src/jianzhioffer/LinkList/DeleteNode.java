package jianzhioffer.LinkList;
/*
18. 给定单向链表头指针和某个结点指针，删除此结点，O(1)
    思路：将此结点的下一个结点的值复制给此结点,指针指向下下个结点
    考虑边界

时间复杂度：n-1 个非尾结点(n-1)*1 尾结点 n O[((n-1)*O(1) + O(n))]/n = O(1)
 */
public class DeleteNode {
    public static class Node {
        public int value;
        public Node next;

        public Node (int data) {
            this.value = data; //初始化时候，哪个对象调用就代表谁
        }
    }


    public static void deleteNode(Node head, Node node) {
        if (head == null || node == null) {
            return;
        }
        //链表中只有一个结点
        if (node == head) {
            head = null; //整个结点指置为空
        }
        //删除尾结点
        else if (node.next == null){
            //找到所要删除结点的前一个结点
            Node cur = head;
            //找到node的前一个结点
            while (cur.next != node) {
                 cur =  cur.next;
            }
            cur.next = null; //将node结点
        }
        //删除中间结点
        else {
             Node cur = node.next; //保存当前结点的下一个结点
             node.value = cur.value;//将下一个结点值赋给node结点
             node.next = cur.next; //node结点指针跳过cur结点
        }
    }

    public static void printLinkList(Node head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1); //类实例化，创建对象
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        printLinkList(head);
        deleteNode(head, head.next);
        printLinkList(head);
    }
}
