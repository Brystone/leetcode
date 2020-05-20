package leetcode.dp;

/**
 * @author stone
 * @version 1.0
 * @ClassName LongestCommonSubString
 * @Description 最长公共子串
 * @date 2020/5/410:26
 */

public class LongestCommonSubString {
    public int longestCommonSubString(String s1, String s2) {
         char[] c1 = s1.toCharArray();
         char[] c2 = s2.toCharArray();
         //dp[i][j] 字符串二维数组，两个字符串以i、j索引结尾的最大公共子串
         int[][] dp = new int[c1.length][c2.length];

        //base dp矩阵第一行
         for (int j=0; j<c2.length; j++) {
            if (c1[0] == c2[j]) {
                dp[0][j] = 1;
            }
        }
        //第一列
        for (int i=1; i<c1.length; i++) {
             if (c1[i] == c2[0]) {
                 dp[i][0] = 1;
             }
        }

        //一般情况
        for (int i=1; i<c1.length; i++) {
             for (int j=1; j<c2.length; j++) {
                 if (c1[i] == c2[j]) {
                     dp[i][j] = dp[i-1][j-1] + 1;
                 }
             }
        }
        return dp[c1.length-1][c2.length-1];
    }
}
