package jianzhioffer.tree;

/*
序列化二叉树：在数字后面加！加以区分  递归先序遍历
 */
public class SerialBinaryTreeByPre {
    private class BinaryTreeNode{
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        private BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    private String serialBinaryTreeByPre(BinaryTreeNode root) {
        if (root == null) {
                return null;
        }
        String res = root.value + "!"; //直接赋值 JVM不会分配内存
        serialBinaryTreeByPre(root.left);
        serialBinaryTreeByPre(root.right);

        return res;
    }

}
