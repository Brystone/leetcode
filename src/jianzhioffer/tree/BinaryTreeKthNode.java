package jianzhioffer.tree;

import java.util.ArrayList;

/*
找到树中第k大的结点，使用数组存放中序遍历的结果，直接输出

 */
public class BinaryTreeKthNode {
    private class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        private BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    private int binaryTreeKthNode(BinaryTreeNode root, int num) {
        ArrayList<BinaryTreeNode> arr = new ArrayList<>();
        InOrder(root, arr);
        return arr.indexOf(num);
    }

    private void InOrder(BinaryTreeNode root, ArrayList arrayList) {
        if (root == null) {
            return;
        }
        InOrder(root.left, arrayList);
        arrayList.add(root);
        InOrder(root.right, arrayList);
    }
}
