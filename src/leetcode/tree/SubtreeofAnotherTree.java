package leetcode.tree;

/*
572. Subtree of Another Tree 判断子树
     3
    / \
   4   5
  / \
 1   2

   4
  / \
 1   2
 */


public class SubtreeofAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        //
        if (s == null && t == null) {
            return true;
        }
        //任意一个为空，返回false
        if (s == null || t == null) {
            return false;
        }
        //对结点的操作
        if (s.val != t.val) {
            return false;
        }
        //递归左右子树
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}
