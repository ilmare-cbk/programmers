package Q21317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 징검다리 건너기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] jump = new int[N][2];
        int[][] dp = new int[N + 1][2];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jump[i][0] = Integer.parseInt(st.nextToken());
            jump[i][1] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        if (N >= 2) {
            for (int i = 1; i <= N; i++) {
                if (i == 1) dp[1][0] = dp[1][1] = 0;
                if (i == 2) dp[2][0] = dp[2][1] = jump[1][0];
                if (i >= 3) {
                    dp[i][0] = Math.min(dp[i - 1][0] + jump[i - 1][0], dp[i - 2][0] + jump[i - 2][1]);
                    dp[i][1] = Math.min(dp[i - 1][1] + jump[i - 1][0], dp[i - 2][1] + jump[i - 2][1]);
                }
                if (i >= 4) dp[i][1] = Math.min(dp[i - 3][0] + K, dp[i][1]);
            }
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
