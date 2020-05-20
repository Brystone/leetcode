package jianzhioffer.dp;

/**
 * 题目：64. 最小路径和
 * 思路：dp[i][j] = grid(i, d) + Min(dp[i+1][j], dp[i][j+1])
 *边界是 最后一行和最后一列
 *
 * @author ：stone
 * @date ：Created in 2020/3/21 20:34
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        //从网格右下角开始
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1) //最后一行只能向右
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1) //最后一列只能向下
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1) //中间即能向下也能向右，选一个较小的路径值
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j]; //右下角最后一个数
            }
        }
        return dp[0][0];
    }
}
