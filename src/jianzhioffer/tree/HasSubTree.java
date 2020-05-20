package jianzhioffer.tree;


public class HasSubTree {
    private class BinartTreeNode{
        int value;
        BinartTreeNode left;
        BinartTreeNode right;

        public BinartTreeNode(int value) {
            this.value = value;
        }
    }
/*
1.根结点相等，看左右子结点不相等，若左右子结点等于根节点，递归
 */
    private boolean hasSubTree(BinartTreeNode root1, BinartTreeNode root2) {
         boolean res = false;
        if (root1 == null || root2 == null) {
            return false;
        }

        //根结点值相同，遍历子结点
        if (root1.value == root2.value) {
            res = WhetherhasSubTree(root1, root2);
        }

        //1.根结点值不等 2.根结点相等，但子树不等
        if (!res) {
            res =  WhetherhasSubTree(root1.left, root2);
        }

        if (!res) {
            res =  WhetherhasSubTree(root1.right, root2);
        }
        return res;
    }

    private boolean WhetherhasSubTree(BinartTreeNode node1, BinartTreeNode node2) {
        if (node2 == null) {
            return true;
        }

        if (node1 == null) {
            return false;
        }

        if (node1.value != node2.value) {
            return false;
        }

        return WhetherhasSubTree(node1.left, node2.left) && WhetherhasSubTree(node1.right, node2.right);
    }
}
