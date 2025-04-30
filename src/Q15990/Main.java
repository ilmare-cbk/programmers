package Q15990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 5
 */
public class Main {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[4][100001];
        dp[1][1] = dp[2][2] = dp[1][3] = dp[2][3] = dp[3][3] = 1;

        for (int i = 4; i <= 100000; i++) {
            dp[1][i] = (dp[2][i - 1] + dp[3][i - 1]) % MOD;
            dp[2][i] = (dp[1][i - 2] + dp[3][i - 2]) % MOD;
            dp[3][i] = (dp[1][i - 3] + dp[2][i - 3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[1][n] + dp[2][n] + dp[3][n]) % MOD).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
