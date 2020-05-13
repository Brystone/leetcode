package leetcode.tree;

import java.util.LinkedList;

/*
226 E. Invert Binary Tree 翻转二叉树
     4      使用队列，交换结点
   /   \
  2     7
 / \   / \
1   3 6   9

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */
public class InvertBinaryTree {
    /**
     * 1.递归形式，速度快，占用空间大
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        /*
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
        */
        /**
         * 好理解，遇到结点将其左右子树交换
         */
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    /**
     * 2.迭代方法
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        //结点入队列
        LinkedList<TreeNode> quene = new LinkedList<>();
        quene.add(root);

        //遍历栈
        while (!quene.isEmpty()) {
            TreeNode node = quene.pop();
            if (node != null) {
                quene.add(node.left);
                quene.add(node.right);
                //将结点交换位置
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
        }
        return root;
    }
}
