package leetcode.dp;

/**
 * 题目：1143. 最长公共子序列 M 子序列可以不连续
 * 思路：dp[i][j]: lcs, 两个字符串从后向前扫描，
 * 状态转移方程 dp[i][j] =
 *
 * @author ：stone
 * @date ：Created in 2020/4/26 20:15
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();

        for (int i=1; i<s1.length; i++) {
            for (int j=1; j<s2.length-1; j++) {
                if (s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[s1.length-1][s2.length-1];
    }
}
