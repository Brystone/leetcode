package newcoder;

import java.util.Stack;

public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /*
    借助辅助空间 使用栈 需要最后的结果 O(n)
     */
    public static boolean isPalindromeList(Node head) { //参数一般给头结点
        //定义栈，用；来存储元素
        Stack<Node> stack = new Stack<Node>();
        Node cur = head; //结点进栈

        while (cur != null) {
            stack.push(cur);
            cur = cur.next; //下一个元素进栈

            //让元素出栈，遍历原链表 进行比较
            while (head != null) {
                if (head.value != stack.pop().value) {
                    return false;
                }
                head = head.next;
            }
        }
        return true;
    }
}
