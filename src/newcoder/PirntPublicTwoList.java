package newcoder;

/*
打印两个有序链表的公共部分
 */
public class PirntPublicTwoList {

    //定义结点类
    public static class Node {
        public int value;
        public Node next;

        //构造方法将数据传给结点中的值
        public Node(int data) {
            this.value = data;
        }
    }

    /*
    类似于归并排序,谁小谁移动,相等就一起移动到下一个结点
    打印没有返回值，参数为两个结点
     */
    public static void printPublic(Node head1, Node head2) {
        //遍历两个链表
        while (head1!=null && head2!=null) {
            if (head1.value < head2.value) {
                head1 = head1.next; //指针不需要++，指向下一个就好
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    //打印链表 参数是结点
    public static void printList(Node node) {
        while (node!=null) {
            System.out.println(node.value);
            node = node.next;//指向下一个
        }
    }

    //测试
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(4);

        printList(node1);
        printList(node2);
        System.out.println("----");
        printPublic(node1, node2);
    }
}
