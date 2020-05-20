package leetcode.dp;

/**
 * 题目：64. 最小路径和
 * 思路：第一行 第一列 dp[i][j]:表示从(0, 0) 到 (i, j) 最短的路径
 *
 * @author ：stone
 * @date ：Created in 2020/4/27 21:52
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        //base case
        dp[0][0] = grid[0][0];
        //第一行
        for (int i=1; i<row; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //第一列
        for (int j=1; j<col; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        //除去边界
        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
