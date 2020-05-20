package jianzhioffer.LinkList;

public class ComplexListNodeClone {
    public class ComplexNode {
        int value;
        ComplexNode next = null;
        ComplexNode random = null; //指向任意结点或者空

        public ComplexNode(int num) {
            this.value = num;
        }
    }

    public ComplexNode complexListNodeClone(ComplexNode head) {
        copyNode(head);
        setCloneNodeRandomNode(head);
        return split(head);
    }

    public void copyNode(ComplexNode head) {
        if (head == null) {
            return;
        }
        ComplexNode cur = head;
        while (cur != null) { // 最后一个结点也复制
            ComplexNode cloneNode = new ComplexNode(cur.value); //创建新结点
            cloneNode.next = cur.next; //不用先保存
            cur.next = cloneNode;
            cur = cloneNode.next;
        }
    }

    public void setCloneNodeRandomNode(ComplexNode head) {
        ComplexNode cur = head;

        while (cur.next != null) {
            ComplexNode cloneHead = cur.next; //这里会再赋值
            if (cur.random != null) {
                cloneHead.random = cur.random.next; //赋值后的结点
            }
            cur = cloneHead.next;
        }
    }

    //返回头结点
    public ComplexNode split(ComplexNode head) {
        ComplexNode cur = head;
        ComplexNode clondeHead = cur.next;

        while (cur.next != null) {
            ComplexNode cloneNode = cur.next;
            if (cloneNode.next != null) {
                cloneNode.next = cloneNode.next.next;
            }
            //移动结点
            cur.next = cur.next.next; //多用一个变量
            cur = cur.next;
        }
        return clondeHead;
    }
 }
