package Q15992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1, 2, 3 더하기 7
 */
public class Main {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[1001][1001];
        for (int i = 1; i <= 1000; i++) {
            dp[i][i] = 1;
        }
        dp[2][1] = dp[3][1] = 1;
        dp[3][2] = dp[2][1] + dp[1][1];

        for (int i = 4; i <= 1000; i++) {
            for (int j = 2; j < 1000; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % MOD;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[n][m]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
