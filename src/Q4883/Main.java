package Q4883;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 삼각 그래프
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[100001][3];
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                dp[i][0] = Integer.parseInt(st.nextToken());
                dp[i][1] = Integer.parseInt(st.nextToken());
                dp[i][2] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (i == 1) {
                    dp[i][0] = Integer.MAX_VALUE;
                    dp[i][2] = dp[i][1] + dp[i][2];
                } else {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + dp[i][0];
                    dp[i][1] = Math.min(dp[i][0], Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]))) + dp[i][1];
                    dp[i][2] = Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2])) + dp[i][2];
                }
            }
            sb.append(T++).append(". ").append(dp[N][1]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
