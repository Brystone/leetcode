package leetcode.tree;

/*
236 M. Lowest Common Ancestor of a Binary Tree
二叉树两节点的公共祖先

       _______3______
      /              \
  ___5__           ___1__
 /      \         /      \
6        2       0        8
        /  \
       7    4
 */

/**
 * 这题用的是后序遍历
 */
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件为找到了 p、q 节点，或者后续没有节点了
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q); // 左右任意一个不为空要么 是 p、q其中一个，要么是其公共结点
        // 如果 root 节点左右子树中，都查找出了 p、q 节点，那么说明 root 节点就是最近的公共节点
        if(left != null && right != null){
            return root;
        }
        // 否则，只要不为 null 的一方就是最近的公共节点，因为它是最先被查出来的
        return left != null ? left : right;
    }
}
