package Q15991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 6
 */
public class Main {
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 100000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) sb.append(1);
            else if (n == 2) sb.append(2);
            else if (n == 3) sb.append(2);
            else {
                if (n % 2 == 0) {
                    sb.append((dp[n / 2] + dp[(n - 2) / 2]) % MOD);
                } else {
                    sb.append((dp[(n - 1) / 2] + dp[(n - 3) / 2]) % MOD);
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
