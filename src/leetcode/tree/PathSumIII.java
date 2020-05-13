package leetcode.tree;

/*
437 E. Path Sum III        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10   判断路径中等于num的数量
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

 */
public class PathSumIII {
    int count = 0;

    /**
     * 1.先序遍历树，主方法中先根结点，然后左右结点  O(nlogn)
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;

    }
    //
    public void sum(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) count++;
        sum(root.left, sum);
        sum(root.right, sum);
    }
}
