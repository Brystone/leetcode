package leetcode.tree;

/**
 * 题目：538. 把二叉搜索树转换为累加树
 * 思路：反序遍历， 右边-根-左边
 *
 * @author ：stone
 * @date ：Created in 2020/3/25 18:29
 */
public class ConvertBST {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        reverseOrder(root);
        return root;
    }
    public void reverseOrder(TreeNode root) {
        if (root == null) return ;
        reverseOrder(root.right);
        root.val = root.val + sum;
        sum = root.val;
        reverseOrder(root.left);
    }
}

