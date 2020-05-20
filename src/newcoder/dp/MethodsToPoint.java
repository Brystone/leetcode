package newcoder.dp;

/**
 * 题目：机器人到达指定位置的所有方法
 * 一排一共1 ~ N 个位置 机器人在M位置上，只能往左或者往右走，指定K步 到达P位置 有多少种方法
 * 思路：dp[j][i]: 这两个参数描述了机器人的状态，在什么位置，还能走几步
 * 选择：要么从左边到 j位置，要么从右边到j 位置 即 dp[j][i] = dp[j-1][i-1] + dp[j+1][i-1]
 * base:
 * @author ：stone
 * @date ：Created in 2020/4/29 16:55
 */
public class MethodsToPoint {
    public int methodsToPoint(int N, int M, int K, int P) {
        int[][] dp = new int[N][K+1];
        //base  当前在P位置，走完所有步数，说明有一种方法可以到P
        dp[P][0] = 1;

        for (int j=1; j<M; j++) {
            for (int i=1; i<K; i++) {
                //两个边界
                if (j == 1) dp[j][i] = dp[2][i-1];
                else if (j == N) dp[j][i] = dp[N-1][i-1];
                //正常情况
                else dp[j][i] = dp[j-1][i-1] + dp[j+1][i-1];
            }
        }
        return  dp[M][K];
    }
}
