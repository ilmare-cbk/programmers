package Q15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 3
 */
public class Main {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n + 1];

            if (n >= 1) dp[1] = 1;
            if (n >= 2) dp[2] = 2;
            if (n >= 3) dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
            }
            sb.append(dp[n]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
