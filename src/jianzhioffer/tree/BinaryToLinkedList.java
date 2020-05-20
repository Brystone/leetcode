package jianzhioffer.tree;

/**
 * 双百解法
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
 */
public class BinaryToLinkedList {
    TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return root;
        inOrder(root);
        head.right =  pre;
        pre.left = head;
        return head;
    }

    public void inOrder(TreeNode cur) {
        if (cur == null) return;
        inOrder(cur.left);
        if (pre != null) {
            pre.right = cur;
            cur.left = pre;
        } else head = cur;
        pre = cur;
        inOrder(cur.right);
    }
}
