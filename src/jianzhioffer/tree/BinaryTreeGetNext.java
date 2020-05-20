package jianzhioffer.tree;

public class BinaryTreeGetNext {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    private TreeLinkNode binaryTreeGetNext(TreeLinkNode  pNode) {
        //当前结点有右子树，并且右子树有左子结点，下一个结点是左子结点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
            //当前结点无右子树：1.当前结点位左子结点，直接返回父结点 //2.当前结点为右节点，则向上 直到找到父节点的没被遍历过的左节点
            //合并两种情况，当前结点为 根节点没有右子树，返回null
        } else {
           while (pNode.next != null && pNode.next.left != pNode) {
               pNode = pNode.next;
           }
           //当前结点为左子节点则
           return pNode.next;
        }
    }
}
