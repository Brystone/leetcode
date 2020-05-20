package leetcode.dp;

/**
 * 题目：62. 不同路径
 * 思路：dp[i][j] = dp[i-1][j] + dp[i][j-i] 注意边界，第一行和第一列都是 1
 *
 * @author ：stone
 * @date ：Created in 2020/3/21 20:16
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i= 0;  i<m; i++) dp[i][0] = 1;
        for (int j= 0;  j<n; j++) dp[0][j] = 1;
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
