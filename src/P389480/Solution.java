package P389480;

import java.util.Arrays;

/**
 * 완전범죄
 */
public class Solution {
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        int[][] dp = new int[size + 1][m];
        int INF = 120;
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 1 ; i <= size; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];
            for (int j = 0; j < m; j++) {
                // A가 훔치는 경우
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);

                // B가 훔치는 경우
                if (b + j < m) {
                    dp[i][b + j] = Math.min(dp[i][b + j], dp[i - 1][j]);
                }
            }
        }

        int answer = INF;
        for (int i = 0; i < m; i++) {
            answer = Math.min(answer, dp[size][i]);
        }

        return answer >= n ? -1 : answer;
    }

}
