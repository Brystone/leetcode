package leetcode.array;

/**
 * 题目：108.Convert Sorted Array to Binary Search Tree 有序数组转为二叉搜索树
 * 思路：有序数组从中间递归
 *
 * @author ：stone
 * @date ：Created in 2020/1/31 20:45
 */
public class ConvertSortedArrayBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode node = help(nums, 0, nums.length-1);
        return node;
    }

    public TreeNode help(int[] nums, int l, int r) {
        if (l>r) return null;
        if (l==r) return new TreeNode(nums[l]);
        int mid = (l+r) / 2; //根节点是中点
        TreeNode root = new TreeNode(mid);
        root.left = help(nums, l, mid-1);
        root.right = help(nums, mid+1, r);
        return root;
    }
}
